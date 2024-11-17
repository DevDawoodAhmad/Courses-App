package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.data.TopicsData
import com.example.coursesapp.pack.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small),
                        top = dimensionResource(id = R.dimen.padding_small)
                    ))
                }
            }
        }
    }
}
@Composable
fun TopicGrid(modifier:Modifier = Modifier){
    LazyVerticalGrid(
        columns =GridCells.Fixed(2) ,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ){
        items(TopicsData.listOfTopics){topic->
            MyListCard(topic = topic)
        }
    }

}
@Composable
fun MyListCard(modifier : Modifier = Modifier, topic : Topic){
 Card() {
     Row() {
         Box {

             Image(painter = painterResource(id = topic.imageId),
                 modifier = Modifier.size(width = 68.dp, height = 68.dp),
                 contentDescription = null,
                 contentScale = ContentScale.Crop)
         }
         Column {

             Text(text = stringResource(id = topic.stringId),
                 style = MaterialTheme.typography.bodyMedium
                 ,modifier = modifier.padding(
                     start = dimensionResource(id = R.dimen.padding_medium),
                     top = dimensionResource(id = R.dimen.padding_medium),
                     end = dimensionResource(id = R.dimen.padding_medium),
                     bottom = dimensionResource(id = R.dimen.padding_small)
                 ))
             Row (verticalAlignment = Alignment.CenterVertically){
                 Text(text = ":/:",
                     modifier = modifier.padding(start = 16.dp))

                 Text(text = topic.marks.toString(),
                     style = MaterialTheme.typography.labelMedium,
                     modifier = modifier.padding(start = 8.dp))
             }
         }
     }

 }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesAppTheme {
        TopicGrid(modifier = Modifier.padding(
            start = dimensionResource(id = R.dimen.padding_small),
            end = dimensionResource(id = R.dimen.padding_small),
            top = dimensionResource(id = R.dimen.padding_small)
        ))

    }
}