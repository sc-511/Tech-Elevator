package com.techelevator.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.TradeDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Account;
import com.techelevator.model.AccountAuthorization;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.Comic;
import com.techelevator.model.ComicAuthorization;
import com.techelevator.model.InvalidComicException;
import com.techelevator.model.NewAccountDTO;
import com.techelevator.model.NewComicDTO;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeAuthorization;
import com.techelevator.dao.ComicDAO;


@RestController
@CrossOrigin
@RequestMapping("/account")

public class AccountController {
	private AccountDAO accountDAO;
    private UserDAO userDAO;
    private TradeDAO tradeDAO;
    private ComicDAO comicDAO;

    public AccountController(AccountDAO accountDAO, UserDAO userDAO, TradeDAO tradeDAO, ComicDAO comicDAO) {
        this.accountDAO = accountDAO;
        this.userDAO = userDAO;
        this.tradeDAO = tradeDAO;
        this.comicDAO = comicDAO;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping( value = "", method = RequestMethod.GET)
    public Account getAccount(Principal principal) throws UsernameNotFoundException {
        Long userId = getCurrentUserId(principal);
        return accountDAO.getAccountByUserId(userId);
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/allaccounts", method = RequestMethod.GET)
    public List<Account> getAccountsByUser(Principal principal) {
    	return accountDAO.getAccountsByUserId(getCurrentUserId(principal));
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/collections/{id}/comics", method = RequestMethod.GET)
    public List<Account> ComicsInCollection (Principal principal, @PathVariable Long id) {
    	Long userId = getCurrentUserId(principal);
    	return accountDAO.getComicsByCollection(userId, id);
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "comics/{id}", method = RequestMethod.GET)
    public Long getComicIdByAccountId (@PathVariable Long id) {
    	return accountDAO.getComicIdByAccountId(id);
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account addAccount(@Valid @RequestBody NewAccountDTO accountDTO, NewComicDTO comicDTO, Principal principal) {
    	Account account = buildAccountFromAccountDTO(accountDTO);
    	Comic comic = buildComicFromComicDTO(comicDTO);
    	Long accountTypeId = account.getAccountTypeId();
    	validateAuthorizationToCreate(principal, account);
    	if(Account.STANDARD_USER_ACCOUNT.equals(accountTypeId)) {
    		addAccountForStandardAccount(comic, account);
    	} else if(Account.PREMIUM_USER_ACCOUNT.equals(accountTypeId)) {
    		addAccountForPremiumAccount(comic, account);
    	}
    	return account;
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/trades", method = RequestMethod.GET)
    public List<Trade> getTrades(Principal principal) {
        return tradeDAO.getTradesForUser(getCurrentUserId(principal));
    }
    
    @RequestMapping(value = "/leaderboards/comicCount", method = RequestMethod.GET)
    public List<Account> getStatisticsComicCount() {
    	return accountDAO.getComicCountOverallByUser();
    }
    
    @RequestMapping(value = "/leaderboards/collectionCount", method = RequestMethod.GET)
    public List<Account> getStatisticsCollectionCount() {
    	return accountDAO.getCollectionCountOverallByUser();
    }
    
    @RequestMapping(value = "/leaderboards/mint", method = RequestMethod.GET)
    public List<Account> getStatisticsMint() {
    	return accountDAO.getMintComicCountByUser();
    }
    
    @RequestMapping(value = "/leaderboards/fair", method = RequestMethod.GET)
    public List<Account> getStatisticsFair() {
    	return accountDAO.getFairComicCountByUser();
    }
    
    @RequestMapping(value = "/leaderboards/poor", method = RequestMethod.GET)
    public List<Account> getStatisticsPoor() {
    	return accountDAO.getPoorComicCountByUser();
    }
    
    private Long getCurrentUserId(Principal principal) {
        return userDAO.findByUsername(principal.getName()).getId();
    }
    
    private Account buildAccountFromAccountDTO(NewAccountDTO accountDTO) {
    	return new Account(accountDTO.getAccountId(),
    						accountDTO.getUserId(),
    						accountDTO.getComicId(),
    						accountDTO.getComicConditionId(),
    						accountDTO.getComicTradableStatusId(),
    						accountDTO.getCollectionId(),
    						accountDTO.getAccountTypeId()
    						);
    }
    
    private Comic buildComicFromComicDTO(NewComicDTO comicDTO) {
    	return new Comic(comicDTO.getComicId(),
    						comicDTO.getComicName(),
    						comicDTO.getAuthorName(),
    						comicDTO.getComicCharacters(),
    						comicDTO.getDatePublished()
    						);
		
    }
    
    private void addAccountForStandardAccount(Comic comic, Account account) {
    	accountDAO.addComicForStandardAccount(comic, account);
    }
    
    private void addAccountForPremiumAccount(Comic comic, Account account) {
    	accountDAO.addComicForPremiumAccount(comic, account);
    }
    
//    private Account addComicForStandardAccount(Comic comic, Account account) {
//    	Account newComic = accountDAO.addComicForStandardAccount(comic, account);
//    }
//    
//    private Comic addComicForPremiumAccount(Comic comic) {
//    	
//    }
    
//	private void validateAuthorizationToView(Principal principal, Account account) {
//		AccountAuthorization auth = new AccountAuthorization(principal, account);
//        if(!auth.isAllowedToView()) {
//        	throw new AuthorizationException();
//        }
//	}
//	
	private void validateAuthorizationToCreate(Principal principal, Account account) {
		AccountAuthorization auth = new AccountAuthorization(principal, account);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
}
