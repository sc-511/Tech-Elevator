-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)

        SELECT actor.first_name, actor.last_name, film.title
        FROM actor 
        JOIN film_actor USING (actor_id)
        JOIN film  USING (film_id)
        WHERE actor.first_name = 'NICK' AND actor.last_name = 'STALLONE'
        ;
        
-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
       
        SELECT actor.first_name, actor.last_name, film.title
        FROM actor 
        JOIN film_actor USING (actor_id)
        JOIN film USING (film_id)
        WHERE actor.first_name = 'RITA' AND actor.last_name = 'REYNOLDS'
        ;
-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

        SELECT actor.first_name, actor.last_name, film.title
        FROM actor 
        JOIN film_actor USING (actor_id)
        JOIN film USING (film_id)
        WHERE (actor.first_name = 'JUDY' OR actor.first_name = 'RIVER') AND actor.last_name = 'DEAN'
        ;
        

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
        
        SELECT film.title, category.name
        FROM film
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        WHERE category.name = 'Documentary'
        ;
        
-- 5. All of the ‘Comedy’ films
-- (58 rows)
        
        SELECT film.title, category.name
        FROM film
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        WHERE category.name = 'Comedy'
        ;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

        SELECT film.title, film.rating
        FROM film
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        WHERE category.name = 'Children' AND film.rating = 'G'
        ;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
        
        SELECT film.title, film.rating
        FROM film
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        WHERE category.name = 'Family' AND film.rating = 'G' AND film.length < 120
        ;
        

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

        SELECT actor.first_name, actor.last_name, film.title
        FROM actor 
        JOIN film_actor USING (actor_id)
        JOIN film  USING (film_id)
        WHERE actor.first_name = 'MATTHEW' AND actor.last_name = 'LEIGH' AND film.rating = 'G'
        ;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

        SELECT film.title
        FROM film
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        WHERE category.name = 'Sci-Fi' AND film.release_year = '2006'
        ;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

        SELECT actor.first_name, actor.last_name, film.title
        FROM actor 
        JOIN film_actor USING (actor_id)
        JOIN film  USING (film_id)
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        WHERE actor.first_name = 'NICK' AND actor.last_name = 'STALLONE' AND category.name = 'Action'
        ;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
        
        SELECT store.store_id, address.address, address.district, city.city, country.country
        FROM store
        JOIN address USING (address_id)
        JOIN city USING (city_id)
        JOIN country USING (country_id)
        ;

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
        
        SELECT store.store_id, address.address, store.manager_staff_id
        FROM store
        JOIN address USING (address_id)
        JOIN city USING (city_id)
        JOIN country USING (country_id)
        ;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
        
        SELECT customer.first_name, customer.last_name, COUNT(rental.customer_id)
        FROM customer
        JOIN rental USING (customer_id)
        GROUP BY customer.first_name, customer.last_name
        ORDER BY COUNT(rental.customer_id) DESC
        LIMIT 10
        ;
        
-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
        
        SELECT customer.first_name, customer.last_name, SUM(payment.amount) AS dollars_spent
        FROM customer
        JOIN payment USING (customer_id)
        GROUP BY customer.first_name, customer.last_name
        ORDER BY SUM(amount) DESC
        LIMIT 10
        ;
        
-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

        SELECT store.store_id, address.address, COUNT(payment.staff_id), SUM(payment.amount), AVG (payment.amount)
        FROM store
        JOIN address USING (address_id)
        JOIN inventory USING (store_id)
        JOIN rental USING (inventory_id)
        JOIN payment USING (rental_id)
        GROUP BY store.store_id, address.address
        ORDER BY store.store_id
        ;
        
-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
        
        SELECT film.title, COUNT(inventory_id)
        FROM film
        JOIN inventory USING (film_id)
        JOIN rental USING (inventory_id)
        GROUP BY film.title
        ORDER BY COUNT(inventory_id) DESC
        LIMIT 10
        ;
        
-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
        
        SELECT category.name, COUNT(inventory_id)
        FROM category
        JOIN film_category USING(category_id)
        JOIN film USING (film_id)
        JOIN inventory USING (film_id)
        JOIN rental USING (inventory_id)
        GROUP BY category.name
        ORDER BY COUNT (inventory_id) DESC
        LIMIT 5
        ; 
        
-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
        
        SELECT film.title, COUNT(inventory_id)
        FROM film
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        JOIN inventory USING (film_id)
        JOIN rental USING (inventory_id)
        WHERE category.name = 'Action'
        GROUP BY film.title
        ORDER BY COUNT(inventory_id) DESC
        LIMIT 5
        ;
        
-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
       
        SELECT actor.first_name, actor.last_name, COUNT(rental.inventory_id)
        FROM actor
        JOIN film_actor USING (actor_id)
        JOIN film USING (film_id)
        JOIN inventory USING (film_id)
        JOIN rental USING (inventory_id)
        GROUP BY actor.actor_id, actor.first_name, actor.last_name
        ORDER BY COUNT(rental.inventory_id) DESC
        LIMIT 10
        ;
        
-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
        
        SELECT actor.first_name, actor.last_name, COUNT(rental.inventory_id)
        FROM actor
        JOIN film_actor USING (actor_id)
        JOIN film USING (film_id)
        JOIN film_category USING (film_id)
        JOIN category USING (category_id)
        JOIN inventory USING (film_id)
        JOIN rental USING (inventory_id)
        WHERE category.name = 'Comedy'
        GROUP BY actor.actor_id, actor.first_name, actor.last_name
        ORDER BY COUNT(rental.inventory_id) DESC
        LIMIT 5
        ; 
        