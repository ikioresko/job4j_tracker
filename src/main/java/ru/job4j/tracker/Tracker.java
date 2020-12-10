package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key){
        Item[] rsl = new Item[size];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            Item it = items[i];
            if (it.getName().equals(key)) {
                rsl[temp] = items[i];
                temp++;
            }
        }
        return Arrays.copyOf(rsl,temp);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        items[index] = item;
        return items[index].equals(item);
    }

    public boolean delete(int id) {
        boolean rslt = true;
        int distPos = indexOf(id);
        if (distPos == -1) {
            rslt = false;
            return rslt;
        }
        int start = distPos + 1;
        int length = size - distPos;
        System.arraycopy(items, start, items, distPos, length);
        items[size-1] = null;
        size--;
        return rslt;
    }
}