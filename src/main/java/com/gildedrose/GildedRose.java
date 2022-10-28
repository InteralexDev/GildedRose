package com.gildedrose;

class GildedRose {
    private Item[] items;

    private int maxQualityConstraint = 50;

    private int minQualityConstraint = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void applyMaxQualityConstraint(Item currentItem) {
        if (currentItem.quality > maxQualityConstraint) {
            currentItem.quality = maxQualityConstraint;
        }
    }

    public void applyMinQualityConstraint(Item currentItem) {
        if (currentItem.quality < minQualityConstraint) {
            currentItem.quality = minQualityConstraint;
        }
    }

    public void updateQuality() {
        for (Item currentItem : this.items) {
            switch (currentItem.name) {
                case "Aged Brie":
                    currentItem.sellIn--;
                    currentItem.quality++;
                    applyMaxQualityConstraint(currentItem);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    currentItem.sellIn--;
                    if (currentItem.sellIn <= 0) {
                        currentItem.quality = 0;
                    } else {
                        currentItem.quality++;
                        if (currentItem.sellIn < 11) {
                            currentItem.quality++;
                        }
                        if (currentItem.sellIn < 6) {
                            currentItem.quality++;
                        }
                    }
                    applyMaxQualityConstraint(currentItem);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Conjured Mana Cake":
                    currentItem.sellIn -= 1;
                    if (currentItem.sellIn > 0) {
                        currentItem.quality -= 2;
                    } else {
                        currentItem.quality -= 4;
                    }
                    applyMinQualityConstraint(currentItem);
                    break;
                default:
                    currentItem.sellIn -= 1;
                    if (currentItem.sellIn > 0) {
                        currentItem.quality--;
                    } else {
                        currentItem.quality -= 2;
                    }
                    applyMinQualityConstraint(currentItem);
            }
        }
    }

    public Item[] getItems() {
        return items;
    }

    public int getMaxQualityConstraint() {
        return maxQualityConstraint;
    }

    public int getMinQualityConstraint() {
        return minQualityConstraint;
    }
}
