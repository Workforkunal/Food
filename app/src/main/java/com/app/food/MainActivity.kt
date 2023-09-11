package com.app.food

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.app.food.data.Dish
import com.app.food.data.dishes
import com.app.food.ui.theme.FoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FoodApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodApp() {
    Scaffold(
        topBar = { FoodTopAppBar() }
    ){it->
    LazyColumn(contentPadding = it) {
        items(dishes) {
            FoodItem(
                dish = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
    }
}
@Composable
fun FoodItem(dish: Dish, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val contextforToast = LocalContext.current.applicationContext
    Card (modifier = modifier) {
        Column(
            modifier = modifier
                .clickable { expanded = !expanded }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                FoodInformation(
                    foodName = dish.name,
                    foodIcon = dish.imageResourceId)
            }
            if (expanded)
                FoodBriefing(
                    foodBriefing = dish.briefing,
                    modifier = Modifier
                        .clickable { Toast.makeText(contextforToast,"Nice!!!", Toast.LENGTH_SHORT).show()}
                        .padding(
                            start = dimensionResource(R.dimen.padding_small),
                            top = dimensionResource(R.dimen.padding_small),
                            bottom = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_small)

                    )
                )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        {
            Row (verticalAlignment = Alignment.CenterVertically)
            {
                Text(
                    text = stringResource(R.string.app_bar_name),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
        modifier = modifier
    )
}


@Composable
fun FoodInformation(
    @StringRes foodName:Int,
    @DrawableRes foodIcon: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(foodName),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(
                    top = dimensionResource(R.dimen.padding_small),
                    start = dimensionResource(R.dimen.padding_medium)
                )
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium)
                )
            ,
            painter = painterResource(foodIcon) ,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}
@Composable
fun FoodBriefing(
    @StringRes foodBriefing: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium))

        )
        Text(
            text = stringResource(foodBriefing),
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium)
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FoodPreview() {
    FoodTheme (darkTheme = false) {
        FoodApp()
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FoodDarkThemePreview(){
    FoodTheme(darkTheme = true){
        FoodApp()
    }
}