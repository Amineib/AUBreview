# OnePoint demo app 

This app demonstrates fetching data from a network call using mvvm clean archi, following android best practices. 


## Architectural Approach
- Data layer: data package: containing a remote and a local packages, and a repository implementation extracting the data. The local data is only used for dummy data. 
- Domain layer: domain package: containing a repository interface describing the methods and the return types wanted, and use cases for each case: listing data and details of each data
- Presentation layer: ui package, containing the app's UI. 

## Features

- List Trees 
- Show details of a specific Tree


## Android Architecture Components samples

Android Architecture Components used
- Jetpack Compose
- Compose Navigation
- Retrofit
- Viewmodels
- Flow 
- DI with Dagger Hilt 
