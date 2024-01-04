package com.example.composemvvmnoteapp.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composemvvmnoteapp.R

@Composable
fun AppLogo(modifier: Modifier) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.align(Center)) {
            Image(
                painter = painterResource(id = R.drawable.flower_logo),
                contentDescription = "Logo",
                modifier.height(122.dp)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Flower AI",
                style = MaterialTheme.typography.headlineMedium.copy(color = Color.White),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RowScope.Space(space: Dp) = Box(modifier = Modifier.width(space))

@Composable
fun ColumnScope.Space(space: Dp) = Box(modifier = Modifier.height(space))

fun annotatedStringAtStart(
    annotatedText: String,
    normalText: String,
    annotationColor: Color,
): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(annotationColor)) {
            append(annotatedText)
        }
        append(normalText)
    }
}

fun annotatedStringAtEnd(
    annotatedText: String,
    normalText: String,
    annotationColor: Color
): AnnotatedString {
    return buildAnnotatedString {
        append(normalText)
        withStyle(style = SpanStyle(annotationColor)) {
            append(annotatedText)
        }
    }
}

@Composable
fun LoadLocalResource(modifier: Modifier, id: Int, contentDesc: String) {
    Image(modifier = modifier, painter = painterResource(id = id), contentDescription = contentDesc)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithLabel(
    modifier: Modifier,
    imgIcon: ImageVector,
    tintColor: Color,
    label: String,
    value: String,
    onTextChange: (value: String) -> Unit
) {
    Column(modifier) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Space(space = 4.dp)
        TextField(modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                onTextChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = imgIcon,
                    contentDescription = label,
                    tint = tintColor
                )
            },
            label = { Text(label) },
            colors =  TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UtilsPreview() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        AppLogo(Modifier.fillMaxWidth())
        Space(space = 14.dp)
        Text(
            text = annotatedStringAtStart(
                annotatedText = "Terms and Condition",
                normalText = " I have read that",
                annotationColor = Color.Blue
            ),
            style = MaterialTheme.typography.headlineMedium
        )
        Space(space = 14.dp)
        Text(
            text = annotatedStringAtEnd(
                annotatedText = "Terms and Condition,",
                normalText = " I have read that",
                annotationColor = Color.Blue
            ),
            style = MaterialTheme.typography.headlineMedium
        )
        Space(space = 14.dp)
        Space(space = 14.dp)
        TextFieldWithLabel(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .padding(4.dp),
            imgIcon = Icons.Default.Email,
            label = "Password",
            value = "",
            tintColor = MaterialTheme.colorScheme.primary,
            onTextChange = {

            },
        )
    }
}