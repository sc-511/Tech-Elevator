package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		int initialNumOfBirds = 4;
		int birdsThatFlewAway = 1;
		initialNumOfBirds -= birdsThatFlewAway;
		System.out.println("Birds left on branch: " + initialNumOfBirds);

		// ### EXAMPLE:
		/*int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		int numBirds = 6;
		int numNests = 3;
		numBirds -= numNests;
		System.out.println("Birds to nests: " + numBirds);
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numbOfRaccoons = 3;
		int hungryRaccoons = 2;
		int leftOverRaccoons = numbOfRaccoons - hungryRaccoons; 
		System.out.println("Raccoons left in woods: " + leftOverRaccoons);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numbOfFlowers = 5;
		int numbOfBees = 3;
		int beesToFlowers = numbOfFlowers - numbOfBees;
		System.out.println("Bees to Flowers: " + beesToFlowers);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int numbOfPigeons = 1;
		numbOfPigeons += 1; 
		System.out.println("Piegons eating breadcrumbs: " + numbOfPigeons);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int numbOfOwls = 3;
		numbOfOwls += 2;
		System.out.println("Owls on fence: " + numbOfOwls);
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int numbOfBeavers = 2;
		numbOfBeavers -= 1; 
		System.out.println("Beavers working: " + numbOfBeavers);
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int numbOfToucans = 2;
		numbOfToucans += 1;
		System.out.println("Toucans in all: " + numbOfToucans);
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numbOfSquirrels = 4;
		int numbOfNuts = 2;
		int difference = numbOfSquirrels - numbOfNuts; 
		System.out.println("Difference in squirrels to nuts : " + difference);
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarterWorth = .25 * 1;
		double nickelsWorth = .05 * 2;
		double dimeWorth = .10 * 1;
		double totalWorth = quarterWorth + nickelsWorth + dimeWorth;
		System.out.println("Total money found: " + totalWorth);
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierClass = 18;
		int macadamsClass = 20;
		int flannersClass = 17;
		int totalMuffins = brierClass + macadamsClass + flannersClass;
		System.out.println("Muffins baked total: " + totalMuffins);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoyoCost = .24;
		double whistleCost = .14;
		double totalCost = yoyoCost + whistleCost;
		System.out.println("Total spent: " + totalCost);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int lgMarsh = 8;
		int minMarsh = 10;
		int totalMarsh = lgMarsh + minMarsh;
		System.out.println("Total marshmellows used: " + totalMarsh);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltSnow = 29;
		int brecknockSnow = 17;
		int diffSnow = hiltSnow - brecknockSnow;
		System.out.println("Difference in snow: " + diffSnow);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int startCash = 10;
		int toyTruck = 3;
		int pencilCase = 2; 
		startCash -= (toyTruck + pencilCase);
		System.out.println("Cash left over: " + startCash);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marbleColl = 16;
		int marbleLost = 7;
		marbleColl -= marbleLost;
		System.out.println("Marbles left over: " + marbleColl);
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seashellColl = 19;
		int neededShell = 25;
		neededShell -= seashellColl;
		System.out.println("Needed seashells: " + neededShell);
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8;
		totalBalloons -= redBalloons;
		System.out.println("Green balloons: " + totalBalloons);
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initShelf = 38; 
		int addedTo = 10;
		initShelf += addedTo;
		System.out.println("Books on the shelf: " + initShelf);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int beeLegs = 6;
		beeLegs *= 8;
		System.out.println("The total legs are: " + beeLegs);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCream = 99;
		iceCream = (iceCream * 2) / 100;
		System.out.println("The total cost: " + iceCream);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int rockTotal = 125;
		int rockInv = 64;
		rockTotal -= rockInv;
		System.out.println("Rocks that are needed: " + rockTotal);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int marblesInv = 38;
		int marblesLost = 15;
		marblesInv -= marblesLost;
		System.out.println("Marbles leftover: " + marblesInv);
		
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalDistance = 78;
		int madeDistance = 32; 
		totalDistance -= madeDistance ;
		System.out.println("Miles that are left over: " + totalDistance);
		
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		double morningTime = 90;
		double afterTime = 45;
		morningTime = (morningTime + afterTime) / 60;
		System.out.println("Total time spent shovelint snow: " + morningTime + " Hours");
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hotdogCount = 6;
		double dogCost = .50;
		double totalDog = hotdogCount * dogCost;
		System.out.println("Amount that was spent: " + "$" + totalDog);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int moneyTotal = 50;
		int  pencilCost = 7;
		
		System.out.println("Pencils that can be bought: " + pencilCost);
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int btFlies = 33;
		int orgFlies = 20;
		int redFlies = btFlies - orgFlies;
		System.out.println("Number of red Butterflies: " + redFlies);
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double moneyHad = 1.00;
		double itemCost = .54;
		moneyHad -= itemCost;
		System.out.println("Change recieved: " + moneyHad);
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treeTotal = 13;
		int moreWanted = 12;
		treeTotal += moreWanted;
		System.out.println("Predicted tree amount: " + treeTotal);
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysTill = 2;
		int hoursDay = 24;
		hoursDay *= daysTill;
		System.out.println("Hours till Grandma comes: " + hoursDay);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numCousins = 4;
		int gumEach = 5;
		numCousins *= gumEach;
		System.out.println("Kim will need this much gum: " + numCousins);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		int danMoney = 3;
		int candyCost = 1;
		danMoney -= candyCost;
		System.out.println("Amount of money left over: " + danMoney);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numBoats = 5;
		int pplBoats = 3;
		numBoats *= 3;
		System.out.println("The number of people on boats: " + numBoats);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int legoCount = 380;
		int legoLost = 57;
		legoCount -= legoLost;
		System.out.println("Legos leftover: " + legoCount);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsBkd = 35;
		int muffinsNd = 83;
		muffinsNd -= muffinsBkd;
		System.out.println("Muffins needed to bake: " + muffinsNd);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willCount = 1400;
		int lucyCount = 290;
		willCount -= lucyCount;
		System.out.println("Amount more than lucy: " + willCount);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stckPerPg = 10;
		int totalPg = 22;
		stckPerPg *= totalPg;
		System.out.println("Total stickers: " + stckPerPg);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int totalChildren = 8;
		totalCupcakes /= 8;
		System.out.println("Cupcakes per person: " + totalCupcakes);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerCookies = 47;
		int jarCookies = 6;
		gingerCookies %= jarCookies;
		System.out.println("Left over cookies: " + gingerCookies);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int cTotal = 59;
		int neighbors = 8;
		cTotal %= neighbors;
		System.out.println("Left over croissants: " + cTotal);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesPerTray = 12;
		int cookiesNeeded = 276;
		cookiesNeeded /= cookiesPerTray;
		System.out.println("The number of trays needed: " + cookiesNeeded);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int oneServe = 12;
		int totalMade = 480;
		totalMade /= oneServe;
		System.out.println("Marian made this many servings: " + totalMade);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCupcakes = 53;
		int perBox = 3;
		int leftHome = 2;
		int updatedAmount = lemonCupcakes - leftHome;
		updatedAmount /= perBox;
		System.out.println("Boxes given away: " + updatedAmount);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticks = 74;
		int totalPeople = 12;
		carrotSticks %= 12;
		System.out.println("Carrot sticks left over: " + carrotSticks);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddyBears = 98;
		int numShelves = 7;
		teddyBears /= numShelves;
		System.out.println("Number of shelves filled: " + teddyBears);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int albumPic = 20;
		int totalPic = 480;
		totalPic /= albumPic;
		System.out.println("Albums needed: " + totalPic);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int tradingCards = 94;
		int maxCardBox = 8;
		int boxesFilled = tradingCards / maxCardBox;
		int leftOver = tradingCards % maxCardBox;
		System.out.println("Amount of boxes filled: " + boxesFilled + " " + "Amount of cards leftover: " + maxCardBox);
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int booksTotal = 210;
		int bookShelves = 10;
		booksTotal /= bookShelves;
		System.out.println("Books per shelves: " + booksTotal);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int croissantsTotal = 17;
		int guestsTotal = 7;
		croissantsTotal /= 7;
		System.out.println("Amount of croissants per person: " + croissantsTotal);
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		double billRate = 2.15/60; //both hourly
		double jillRate = 1.90/60;
		double avgRate = (billRate + jillRate) /2;
		double fiveRoomsTime = 5 * avgRate;
		System.out.println(fiveRoomsTime + " Hours" + " for 5 rooms together");
		/*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String firstN = "Shane";
		String lastN = "Craig";
		String MiddleIn = "C";
		String concate = lastN + "," + " " + firstN + " " + MiddleIn + ".";
		System.out.println(concate);
		
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		double amountTraveled = 537;
		double totalTravel  = 800;
		double percentageTravel = (amountTraveled/totalTravel) * 100;
		System.out.println((int) percentageTravel + "%" + " percentage of distance traveled");

	}

}
