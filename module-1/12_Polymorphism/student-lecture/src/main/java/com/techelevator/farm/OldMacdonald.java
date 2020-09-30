package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] farmAnimal = new Singable[] { fa, cow, chicken, johnDeere };
		
		List <Singable> names = new ArrayList <>();
		Map <String, String> 
		names.add(fa);
		names.add(cow);
		names.add(chicken);
		names.add(johnDeere);
				
		Cow cow = new Cow();
		Chicken chicken = new Chicken();
		Tractor johnDeere = new Tractor();

		for (Singable singable : farmAnimal) {
			
			String name = singable.getName();
			String sound = singable.getSound();
			
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
			
		}
	}
}