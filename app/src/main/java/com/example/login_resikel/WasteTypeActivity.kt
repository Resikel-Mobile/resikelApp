package com.example.login_resikel

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Surface
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.login_resikel.ui.theme.Login_ResikelTheme


class WasteTypeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login_ResikelTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val activity = context as? ComponentActivity

    // Cek jika konteks berhasil di-cast menjadi Activity
    activity?.window?.let { window ->
        // Mengatur status bar
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
        topBar = { HeaderSection() },
        bottomBar = { BottomNavigationBar(navController) },
        floatingActionButton = { floatingButton(icon = R.drawable.delete)},
        contentWindowInsets = WindowInsets.systemBars,
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()) {
            NavHost(
                navController = navController,
                startDestination = "home",
                Modifier.padding(innerPadding)
            ) {
                composable("home") { HomeScreen(innerPadding) }
                composable("bookmark") {  }
                composable("lock") { }
                composable("profile") { }
            }
        }
    }
}

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
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
fun floatingButton(icon: Int){
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(72.dp) // Ukuran box
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .background(
                color = colorResource(id = R.color.main_green),
                shape = RoundedCornerShape(36.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                val intent = Intent(context, TrashItemListActivity::class.java)
                context.startActivity(intent)
            }

    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(28.dp),
            tint = Color.Unspecified
        )
    }
}


@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Type of waste",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 24.sp,
            color = colorResource(id = R.color.main_green),
            modifier = Modifier.weight(5f)
        )
        Icon(
            painter = painterResource(id = R.drawable.guard),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContainer(placeHolders: String, padding: Dp, PTop: Dp, PHorizon: Dp, elevationVal : Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .padding(top = PTop)
            .shadow(elevationVal, shape = RoundedCornerShape(99.dp))
            .background(color = Color.White, shape = RoundedCornerShape(99.dp))
            .padding(horizontal = PHorizon)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = placeHolders) },
                textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                    fontSize = 10.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
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
                fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See all",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(72.dp) // Ukuran box
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(36.dp)
                ) // White rounded container
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
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
            fontFamily = FontFamily(Font(R.font.dm_sans_medium)),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "See all",
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
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
fun NonScrollableGrid(listItems : List<CategoryItem>) {
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
                    CategoryItemLayout(icon = item.icon, name = item.name , desc = item.desc, point = item.point)
                }
            }
        }
    }
}

@Composable
fun CategoryItemLayout(icon:Int, name:String, desc:String, point:String){
    Column(modifier = Modifier
        .width(164.dp)
        .height(220.dp)
        .padding(bottom = 16.dp)
        .background(colorResource(id = R.color.white), shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(painter = painterResource(id = icon) , contentDescription = name, modifier = Modifier
            .size(120.dp)
            .padding(horizontal = 16.dp), tint = Color.Unspecified)

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

        Row(modifier = Modifier
            .fillMaxWidth()) {
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
                    ) // White rounded container
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(8.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavItem("home", R.drawable.home, "Home"),
        NavItem("bookmark", R.drawable.bookmark, "Bookmark"),
        NavItem("lock", R.drawable.lock, "Lock"),
        NavItem("profile", R.drawable.profile, "Profile")
    )

    NavigationBar(
        containerColor = colorResource(id = R.color.light_green)
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            modifier = Modifier.size(20.dp)
                        )
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .height(2.dp) // Ketebalan garis
                                    .width(24.dp) // Panjang garis
                                    .background(Color.Black) // Warna garis
                                    .padding(top = 64.dp) // Jarak garis dari ikon
                            )
                        }
                    }
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = colorResource(id = R.color.main_green), // Warna ikon saat terpilih
                    unselectedIconColor = colorResource(id = R.color.main_green) // Warna ikon saat tidak terpilih
                ),
                modifier = Modifier.padding(0.dp)
            )
        }
    }
}


data class NavItem(val route: String, val icon: Int, val label: String)
data class CategoryItem(val icon:Int, val name:String, val desc:String, val point:String, val count:Int)


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}