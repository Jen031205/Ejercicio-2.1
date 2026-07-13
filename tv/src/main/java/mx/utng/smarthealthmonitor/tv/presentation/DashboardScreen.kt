package mx.utng.smarthealthmonitor.tv.presentation

@Composable
fun DashboardTopBar(title: String) {
    TopAppBar(
        title = { Text(title) },
        actions = {
            // CastButton: AndroidView que envuelve MediaRouteButton
            AndroidView(
                factory = { context ->
                    MediaRouteButton(context).apply {
                        CastButtonFactory.setUpMediaRouteButton(context, this)
                    }
                },
                modifier = Modifier.size(48.dp)
            )
        }
    )
}
