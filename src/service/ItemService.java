package service;

import java.util.ArrayList;
import java.util.List;

public class ItemService {

    public List<IntegerItem> getIntegerItems(List<?> sourceItems) {
        List<IntegerItem> integers = new ArrayList<>();
        addIntegerItem(sourceItems, integers);
        return integers;
    }

    private void addIntegerItem(List<?> sourceItems, List<IntegerItem> integers) {
        for (Object item : sourceItems) {
            if (item instanceof IntegerItem) {
                integers.add((IntegerItem) item);
            } else {
                addIntegerItem((List<?>) item, integers);
            }
        }
    }

}
