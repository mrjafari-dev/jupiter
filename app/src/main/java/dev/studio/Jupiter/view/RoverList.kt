package dev.studio.Jupiter.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.studio.Jupiter.R
import dev.studio.Jupiter.domain.model.roverUiModelList


@Composable
fun RoverList(onItemClick: (String) -> Unit){
    LazyColumn{
        itemsIndexed(roverUiModelList){index , item->
            Rover(item.name,item.img , item.landingDate,item.distance){name->
                onItemClick(name)
            }
        }
    }

}


@Preview
@Composable
fun RoverPreview() {
    Rover("SampleText",R.drawable.bot1 , "18 frb 2021","12.56 km"){

    }
}


@Composable
fun Rover(name: String, img: Int, landingDate: String, distance: String,onItemClick: (String) -> Unit) {
    Card (modifier = Modifier.padding(16.dp).clickable { onItemClick(name) }){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, text = name , fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Image(modifier = Modifier.fillMaxWidth().height(160.dp),painter = painterResource(img),contentDescription = null)
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start, text = "created : NASA/JPL" , fontWeight = FontWeight.Medium, fontSize = 8.sp)
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start, text = "Landing date : $landingDate" , fontWeight = FontWeight.Medium, fontSize = 12.sp)
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start, text = "Distance travel : $distance" , fontWeight = FontWeight.Medium, fontSize = 12.sp)

        }

    }

}