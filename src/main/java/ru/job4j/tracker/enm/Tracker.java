package ru.job4j.tracker.enm;

import ru.job4j.tracker.Item;
import java.util.Arrays;

public enum Tracker {
        INSTANCE;
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
            if (index == -1) {
                return false;
            }
            item.setId(id);
            items[index] = item;
            return true;
        }

        public boolean delete(int id) {
            int distPos = indexOf(id);
            if (distPos == -1) {
                return false;
            }
            int start = distPos + 1;
            int length = size - distPos;
            System.arraycopy(items, start, items, distPos, length);
            items[size-1] = null;
            size--;
            return true;
        }

    public static void main(String[] args) {
        Tracker tracker = Tracker.INSTANCE;
    }
}


