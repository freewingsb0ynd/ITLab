import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        //creating sample Collection
        List<Banana> myList = new ArrayList<>();
        myList.add(new Banana("B1",5,30));
        myList.add(new Banana("B1",3,60));
        myList.add(new Banana("B2",1,30));
        myList.add(new Banana("B2",4,20));
        myList.add(new Banana("B2",7,100));

        //Sum
        int weightSum = myList
                .stream()
                .mapToInt(Banana::getWeight)
                .sum();
        System.out.println("Weight Sum of all bananas: " + weightSum);

        //Group
        Map<String,Banana> bananasByName = myList.stream()
                                            .collect(Collectors.toMap(Banana::getName, Function.identity(),
                                            (b1,b2)->{b1.addWeightAndPrice(b2); return b1;}));

        System.out.println("Group bananas by B1 and B2: ");
        bananasByName.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " : " + e.getValue());
        });

        //Max
        int maxPrice = myList
                .stream()
                .mapToInt(Banana::getPrice)
                .max().orElseThrow(NoSuchElementException::new);

        System.out.println("Max Price of all bananas: " + maxPrice);

        //Min
        int minWeight = myList
                .stream()
                .mapToInt(Banana::getWeight)
                .min().orElseThrow(NoSuchElementException::new);

        System.out.println("Min Weight of all bananas: " + minWeight);

        //Filter
        List<Banana> bananasPriceLessThan30 = myList
                .stream()
                .filter(banana -> banana.isType("B2"))
                .collect(Collectors.toList());

        System.out.println("Filter: Bananas B2");
        bananasPriceLessThan30.forEach(e -> {
            System.out.println(e.toString());
        });

        //Map
//        long mapBananaB1 = myList.parallelStream()
//                .map(banana -> banana.isB1()).count();
////                .collect(Collectors.toList());
//        System.out.println(mapBananaB1);

//        //Reduce
//        Optional<Double> resultReduce = myList.parallelStream()
//                .reduce((x,y) -> x*y);

    }
}
