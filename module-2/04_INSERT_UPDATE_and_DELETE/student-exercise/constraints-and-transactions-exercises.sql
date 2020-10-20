-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
        INSERT INTO actor (actor_id, first_name, last_name)
        VALUES (DEFAULT, 'HAMPTON', 'AVENUE')
        ;
        
        INSERT INTO actor (actor_id, first_name, last_name)
        VALUES (DEFAULT, 'LISA', 'BYWAY')
        ;
        
        SELECT *
        FROM actor
        ;
        
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
        INSERT INTO film (film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating)
        VALUES (DEFAULT, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, DEFAULT, DEFAULT, DEFAULT, 198, DEFAULT, DEFAULT)
        ;
        
        SELECT *
        FROM film
        WHERE title = 'Euclidean PI' --film_id = 1001
        ; 
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
        
        -- film_id = 1001
        -- actor_id = 201 -> Hampton Avenue
        -- actor_id = 202 -> Lisa Byway
        
        INSERT INTO film_actor (film_id, actor_id)
        VALUES (1001, 201)
        ;
        
        INSERT INTO film_actor (film_id, actor_id)
        VALUES (1001, 202)
        ;
        
        SELECT *
        FROM film_actor
        WHERE actor_id IN (201, 202)
        ;
-- 4. Add Mathmagical to the category table.
        INSERT INTO category (category_id, name)
        VALUES (DEFAULT, 'Mathmagical')
        ;
        
        SELECT *
        FROM category
        ;
        
-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
        SELECT film.title, film_id
        FROM film
        WHERE film.title IN ('EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE')
        ;
        
        UPDATE film_category
        SET category_id = 17
        WHERE film_id IN (274, 494, 714, 996)
        ;
        
        SELECT film_id, category_id
        FROM film_category
        WHERE category_id = 17
        ;
        
        
-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

        UPDATE film 
        SET rating = 'G'
        WHERE film_id IN (274, 494, 714, 996)
        ;
        
        SELECT title, rating
        FROM film
        WHERE film_id IN (274, 494, 714, 996)
        ;

-- 7. Add a copy of "Euclidean PI" to all the stores.
        INSERT INTO inventory (inventory_id, film_id, store_id)
        VALUES (DEFAULT, 1001, 1)
        ;
        
        INSERT INTO inventory (inventory_id, film_id, store_id)
        VALUES (DEFAULT, 1001, 2)
        ;
        
        SELECT *
        FROM inventory
        ORDER BY film_id DESC
        ;
        
        SELECT store_id, film_id
        FROM inventory
        WHERE film_id = 1001
        ;
        
-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- NO, Cannot delete the film based on the primary/foreign key relationship. Film_id is a foreign key in the film table and a primary key in the film_actor table. This prevents the data from being deleted. 
        DELETE 
        FROM film
        WHERE film_id = 1001
        ;
        
        SELECT film_id, title
        FROM film
        WHERE film_id = 1001
        ;
        
-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- NO,This as well is part of the primary/foreign key relationship. This prevents the data from being deleted. 
        DELETE 
        FROM category
        WHERE category_id = 17
        ;
        
        SELECT category_id, name
        FROM category
        WHERE category_id = 17
        ;

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- YES, Mathmagical is a primary key in this table coming from the film table but it is not a primary key coming from the category table. This allows the data to be deleted since it can go in a direction where the value is not dependent. 
       
        DELETE
        FROM film_category
        WHERE category_id = 17
        ;
        
        SELECT film_id, category_id
        FROM film_category
        WHERE category_id = 17
        ;
        
-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- Yes, category_id is able to be deleted because film_category table only had category_id as a primary key coming from the film table which allowed it to not be tied to an additional table. Euclidean PI's film_id is a foreign key inside the film table which blocks the deletion from happening.
       
        DELETE
        FROM category
        WHERE category_id = 17
        ; 
        
        DELETE
        FROM film
        WHERE film_id = 1001
        ;
        
        SELECT title
        FROM film
        WHERE film_id = 1001
        ;
        
        SELECT category_id, name
        FROM category
        WHERE category_id = 17
        ;
        
-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
        --Euclidean Pi would have to be removed from film_actor first in order to be removed from film that way film_id in film_actor becomes a primary key which would then allow it to be deleted. Such as:
        
        SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
        SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
        SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;
        
        DELETE
        FROM film_actor
        WHERE film_id = 1001
        ;
