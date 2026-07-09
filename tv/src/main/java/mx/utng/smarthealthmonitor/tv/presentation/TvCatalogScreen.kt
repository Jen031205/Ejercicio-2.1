@Composable
fun TvCatalogScreen(
    viewModel: TvViewModel = viewModel(factory = TvViewModelFactory(LocalContext.current))
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(Modifier.fillMaxSize().background(Color(0xFF0D1B4A))) {

        if (state.isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
            return@Box
        }

        TvLazyColumn(
            modifier = Modifier.fillMaxSize().padding(48.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Fila 1: FC actual
            item {
                RowSection(title = "⚡ Estado Actual — ${state.fcActual} bpm") {
                    TvLazyRow(horizontalArrangement=Arrangement.spacedBy(16.dp)) {
                        items(state.lecturas.takeLast(3)) { lectura ->
                            FcCardItem(lectura=lectura, onClick={})
                        }
                    }
                }
            }

            // Fila 2: Historial completo
            item {
                RowSection(title = "📋 Historial FC") {
                    TvLazyRow(horizontalArrangement=Arrangement.spacedBy(16.dp)) {
                        items(state.lecturas) { lectura ->
                            FcCardItem(lectura=lectura, onClick={})
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RowSection(title: String, content: @Composable () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(title, style=MaterialTheme.typography.headlineSmall,
            color=Color.White, fontWeight=FontWeight.Bold)
        content()
    }
}
