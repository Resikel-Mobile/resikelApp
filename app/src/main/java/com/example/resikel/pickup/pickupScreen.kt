package com.example.resikel.pickup

import android.content.Intent
import android.os.Build
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import com.example.resikel.R
import com.example.resikel.ui.theme.SearchContainer
import com.example.resikel.ui.theme.SimpleTextButton
import com.example.resikel.ui.theme.iconWithBackground
import com.example.resikel.ui.theme.montserrat

@Composable
fun pickupScreen(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    // Cek jika konteks berhasil di-cast menjadi Activity
    activity?.window?.let { window ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val insetsController = window.insetsController
            insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = Color.Transparent.toArgb()
        }
    }

    Scaffold(
        topBar = { WasteTypeActivityHeader(navController = navController) },
        floatingActionButton = {
            floatingButton(
                navController = navController,
                icon = R.drawable.trash,
                iconColor = Color.White,
                itemCount = 1
            )
        },
        contentWindowInsets = WindowInsets.systemBars,
    ) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
            ) {
                HomeScreen()
            }
        }
    }
}


@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.grey1))
    ) {
        item {
            SearchContainer("Search...", 24.dp, 1.dp, 16.dp, 0.dp)
        }
        item {
            CategoriesSection()
        }
        item {
            SelectTrashSection()
        }
    }
}

@Composable
fun floatingButton(navController: NavController, icon: Int, iconColor: Color, itemCount: Int) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }

    Box() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(72.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(
                    color = colorResource(id = R.color.main_green),
                    shape = RoundedCornerShape(36.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    navController.navigate("trashItemList")
                }

        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(28.dp),
                tint = iconColor
            )
        }
        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(top = 32.dp)
                .align(Alignment.BottomEnd)
        ) {
            SimpleTextButton(
                backgroundSize = 28.dp,
                textStyle = TextStyle(fontWeight = FontWeight.Bold),
                backgroundColor = colorResource(id = R.color.red_2),
                textContent = itemCount.toString(),
                textSize = 12.sp,
                textColor = Color.White,
                backgroundRadius = 99.dp
            )
        }
    }
}


@Composable
fun WasteTypeActivityHeader(navController: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier

                .size(56.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(
                    color = colorResource(R.color.main_green),
                    shape = RoundedCornerShape(36.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    navController.popBackStack()
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowleft),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = colorResource(R.color.white)
            )
        }
        Text(
            text = "Type of waste",
            fontWeight = FontWeight.Bold,
            fontFamily = montserrat,
            fontSize = 24.sp,
            color = colorResource(id = R.color.main_green),
            modifier = Modifier.weight(5f)
        )
        Icon(
            painter = painterResource(id = R.drawable.guard),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
    }
}

@Composable
fun CategoriesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 1.dp)

        ) {
            Text(
                text = "Categories",
                fontFamily = montserrat,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                fontFamily = montserrat,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50) // main_green color
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CategoryButton("Organic", R.drawable.organic)
            CategoryButton("Non-Organic", R.drawable.nonorganic)
            CategoryButton("B3", R.drawable.b3)
            CategoryButton("All", R.drawable.all)
        }
    }
}

@Composable
fun CategoryButton(text: String, icon: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        iconWithBackground(
            imageIcon = painterResource(id = icon),
            backgroundColor = Color.White,
            backgroundSize = 72.dp,
            iconSize = 32.dp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            fontFamily = montserrat,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}


@Composable
fun SelectTrashSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Select your trash and deposit it",
            fontFamily = montserrat,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See all",
            fontFamily = montserrat,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50) // main_green color
        )
    }

    val categoryItems = listOf(
        CategoryItem(
            icon = R.drawable.book, // Ganti dengan resource icon yang sesuai
            name = "Book",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 0
        ),
        CategoryItem(
            icon = R.drawable.cardboard,
            name = "Cardboard Box",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 3
        ),
        CategoryItem(
            icon = R.drawable.metal, // Ganti dengan resource icon yang sesuai
            name = "Kaleng",
            desc = "Non-organik",
            point = "2000 points/kg",
            count = 2

        ),
        CategoryItem(
            icon = R.drawable.glass, // Ganti dengan resource icon yang sesuai
            name = "Broken Lamp",
            desc = "B3",
            point = "1500 points/kg",
            count = 1
        ),
        CategoryItem(
            icon = R.drawable.botolkaca,
            name = "Botol Kaca",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 0
        ),
        CategoryItem(
            icon = R.drawable.paperbag,
            name = "Paper Bag",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 0
        ),
        CategoryItem(
            icon = R.drawable.sayuran,
            name = "Sayuran",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 0

        ),
        CategoryItem(
            icon = R.drawable.botolplastik,
            name = "Botol Plastik",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 0

        ),
        CategoryItem(
            icon = R.drawable.tempurungkelapa,
            name = "Tempurung Kelapa",
            desc = "Organik",
            point = "1500 points/kg",
            count = 0

        ),
        CategoryItem(
            icon = R.drawable.alumunium,
            name = "Alumunium",
            desc = "Non-organik",
            point = "1500 points/kg",
            count = 0
        ),

        )
    NonScrollableGrid(categoryItems)
}

@Composable
fun NonScrollableGrid(listItems: List<CategoryItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 12.dp)
    ) {
        listItems.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                rowItems.forEach { item ->
                    CategoryItemLayout(
                        icon = item.icon,
                        name = item.name,
                        desc = item.desc,
                        point = item.point
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryItemLayout(icon: Int, name: String, desc: String, point: String) {
    val interactionSource = remember { MutableInteractionSource() }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .width(164.dp)
            .height(220.dp)
            .padding(bottom = 16.dp)
            .background(colorResource(id = R.color.white), shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = icon), contentDescription = name, modifier = Modifier
                .size(120.dp)
                .padding(horizontal = 16.dp), tint = Color.Unspecified
        )

        Text(
            text = name,
            style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            textAlign = TextAlign.Start
        )

        Text(
            text = desc,
            style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
            color = colorResource(id = R.color.grey3),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 4.dp, bottom = 4.dp),
            textAlign = TextAlign.Start
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = point,
                style = TextStyle(fontWeight = FontWeight.Bold), fontSize = 12.sp,
                color = colorResource(id = R.color.main_green),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
                    .padding(start = 16.dp),
                textAlign = TextAlign.Start
            )

//            BUTTON TAMBAH JUMLAH
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentSize()
                    .weight(2f)
                    .padding(end = 16.dp)
                    .background(
                        color = colorResource(id = R.color.main_green),
                        shape = RoundedCornerShape(36.dp)
                    )
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {

                    }
            ) {
                iconWithBackground(
                    imageIcon = painterResource(id = R.drawable.plus),
                    backgroundColor = colorResource(id = R.color.main_green),
                    iconSize = 32.dp,
                    backgroundSize = 32.dp
                )
            }
        }
    }
}

data class NavItem(val route: String, val icon: Int, val iconSelected: Int, val label: String)
data class CategoryItem(
    val icon: Int,
    val name: String,
    val desc: String,
    val point: String,
    val count: Int
)


@Preview
@Composable
private fun prepickup() {
    pickupScreen(navController = rememberNavController())
}
