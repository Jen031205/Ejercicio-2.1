# SmartHealth Monitor

## Unidad II — Wear OS

| Pantalla              | Descripción                                        |
| --------------------- | -------------------------------------------------- |
| WearDashboardScreen   | FC en tiempo real con ScalingLazyColumn y TimeText |
| WearHistorialScreen   | Lista con Rotary Input (corona del reloj)          |
| WearAlertaScreen      | Botones circulares de confirmación                 |
| SmartHealth WatchFace | Hora + FC en el WatchFace nativo                   |

## Autor

Jennifer Ailín Medina Hernández — UTNG — Ingeniería en Desarrollo y Gestión de Software




----------------------------------------------------------------------------------------------------

## Arquitectura — SmartHealth Monitor

```
Sensor PPG (Wear OS)
    │  Health Services API
    ▼
PassiveListenerService (wear)
    │  MessageClient (BLE)
    ▼
WearListenerService (app)
    │  SmartHealthRepository
    ▼
StateFlow<Int> (fcActual)  ──────────────────────────────────┐
    │                                                        │
    ▼                                                        ▼
DashboardViewModel (app)              TvViewModel (tv)
    │  collectAsState()                    │  collectAsState()
    ▼                                        ▼
DashboardScreen (Compose)          TvCatalogScreen (Compose TV)
    └── CastButton ──► Chromecast (Remote Playback)
 
Room DB (LecturaFC)  ◄──  Repository  ──►  Flow<List<LecturaFC>>
                                                │
                          ┌─────────────────────┴──────────┐
                          ▼                                ▼
               HistorialScreen (app)        TvCatalogScreen (tv)
```
