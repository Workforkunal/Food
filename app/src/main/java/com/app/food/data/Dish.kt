package com.app.food.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.food.R

data class Dish(
    @StringRes val name: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val briefing: Int
)

val dishes = listOf(
    Dish(R.string.food_name_1, R.drawable.sushi, R.string.food_description_1),
    Dish(R.string.food_name_2, R.drawable.rendang, R.string.food_description_2),
    Dish(R.string.food_name_3, R.drawable.ramen, R.string.food_description_3),
    Dish(R.string.food_name_4, R.drawable.tom_yam_goong, R.string.food_description_4),
    Dish(R.string.food_name_5, R.drawable.kebab, R.string.food_description_5),
    Dish(R.string.food_name_6, R.drawable.pho, R.string.food_description_6),
    Dish(R.string.food_name_7, R.drawable.peking_duck, R.string.food_description_7),
    Dish(R.string.food_name_8, R.drawable.paella, R.string.food_description_8),
    Dish(R.string.food_name_9, R.drawable.steak_and_kidney_pie, R.string.food_description_9),
    Dish(R.string.food_name_10, R.drawable.apfelstrudel, R.string.food_description_10),
    Dish(R.string.food_name_11, R.drawable.pad_thai, R.string.food_description_11),
    Dish(R.string.food_name_12, R.drawable.goulash, R.string.food_description_12),
    Dish(R.string.food_name_13, R.drawable.lasagna, R.string.food_description_13),
    Dish(R.string.food_name_14, R.drawable.kimchi, R.string.food_description_14),
    Dish(R.string.food_name_15, R.drawable.fried_chicken, R.string.food_description_15),
    Dish(R.string.food_name_16, R.drawable.dosa, R.string.food_description_16),
    Dish(R.string.food_name_17, R.drawable.massaman_curry, R.string.food_description_17),
    Dish(R.string.food_name_18, R.drawable.pizza, R.string.food_description_18),
    Dish(R.string.food_name_19, R.drawable.hamburger, R.string.food_description_19),
    Dish(R.string.food_name_20, R.drawable.donuts, R.string.food_description_20),
    Dish(R.string.food_name_21, R.drawable.biryani, R.string.food_description_21),
    Dish(R.string.food_name_22, R.drawable.poutine, R.string.food_description_22)
)
