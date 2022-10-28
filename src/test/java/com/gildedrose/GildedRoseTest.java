package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenItemWhenToStringedThenShouldBeComposedFromOriginalValues() {
        Item[] items = new Item[] { new Item("foo", 14, 17) };
        GildedRose app = new GildedRose(items);
        assertEquals("foo, 14, 17", app.getItems()[0].toString());
    }

    @Test
    void givenItemWhenCreatedAndUpdatedThenShouldHaveTheSameName() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItems()[0].name);
    }

    @Test
    void givenItemWhenUpdatedThenShouldHaveALowerSellIn() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(true, app.getItems()[0].sellIn < 0);
    }

    @Test
    void givenItemWhenUpdatedThenGonnaHaveALowerQuality() {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.getItems()[0].quality);
    }

    @Test
    void givenItemWithQualityGreaterThanMaximumWhenUpdatedForBiggerQualityThenGonnaHaveAQualityOfMaximumConstraint() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.getMaxQualityConstraint(), app.getItems()[0].quality);
    }

    @Test
    void givenItemWithQualityLowerThanMinimumWhenUpdatedForLowerQualityThenGonnaHaveAQualityOfMinimumConstraint() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.getMinQualityConstraint(), app.getItems()[0].quality);
    }

    @Test
    void givenItemNamedAgedBrieWhenUpdatedThenGonnaHaveAHigherQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(true, app.getItems()[0].quality > 2);
    }

    @Test
    void givenItemNamedSulfurasWhenUpdatedThenNeedToBeUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(true, app.getItems()[0].quality == 80 && app.getItems()[0].sellIn == 0);
    }

    @Test
    void givenItemNamedBackstageWithSellInOfZeroWhenUpdatedThenNeedQualityToBeSetOnZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.getItems()[0].quality);
    }

    @Test
    void givenItemNamedBackstageWithSellInBiggerThanTenWhenUpdatedThenNeedQualityToBeIncreasedByOne() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.getItems()[0].quality);
    }

    @Test
    void givenItemNamedBackstageWithSellInBetweenSixAndElevenWhenUpdatedThenNeedQualityToBeIncreasedByTwo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.getItems()[0].quality);
    }

    @Test
    void givenItemNamedBackstageWithSellInBetweenZeroAndFiveWhenUpdatedThenNeedQualityToBeIncreasedByTree() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.getItems()[0].quality);
    }

    @Test
    void givenItemNamedConjuredWhenUpdatedThenNeedToBeDecreaseByTwo() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.getItems()[0].quality);
    }

    @Test
    void givenItemNamedConjuredWithSellInLowerThanZeroWhenUpdatedThenNeedToBeDecreaseByFour() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.getItems()[0].quality);
    }

}
