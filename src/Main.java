import service.IntegerItem;
import service.ItemService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<?> sourceItems = Stream.of(
            new IntegerItem(3),
            new IntegerItem(4),
            Stream.of(
                    new IntegerItem(3),
                    Stream.of(
                            new IntegerItem(3),
                            new IntegerItem(4),
                            new IntegerItem(4)
                    ).collect(Collectors.toList()),
                    new IntegerItem(4),
                    new IntegerItem(4)
            ).collect(Collectors.toList())
    ).collect(Collectors.toList());

    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        List<IntegerItem> integerItems = itemService.getIntegerItems(sourceItems);
        integerItems.forEach(item -> System.out.println(item.getValue()));
        System.out.println(integerItems);
    }

}
