# ModularApp

A sample modular project for applying Android Architecture Components and Clean Architecture using MVVM with Kotlin.


## Screenshots
List             |  Detail
:-------------------------:|:-------------------------:
![photo_2020-02-18_19-35-21](https://user-images.githubusercontent.com/8689604/74756597-d96abb00-5285-11ea-891b-95cefcbfe899.jpg)  |  ![photo_2020-02-18_19-35-16](https://user-images.githubusercontent.com/8689604/74756644-f0111200-5285-11ea-9dfc-419ca704affb.jpg)


## Modules

#### Data Layer
The Data layer is responsible for abstracting all the source data that our module uses.

#### Domain Layer
The Domain layer is responsible for the business rules of our module. It contains our Models and Use-Cases.

#### Presentation Layer
The Presentation layer is responsible for presenting the data, animations, lists, and for interacting with the Android Framework. 


## Tech Stack

-   [Kotlin](https://kotlinlang.org/)
-   [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)

#### Patterns
-   [Repository Pattern](https://developer.android.com/jetpack/docs/guide)
-   [Observer Pattern](https://code.tutsplus.com/tutorials/android-design-patterns-the-observer-pattern--cms-28963)

#### Dependencies
-   [AndroidX](https://developer.android.com/jetpack/androidx)
-   [Lifecycle-Aware Components](https://developer.android.com/topic/libraries/architecture/lifecycle)
-   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
-   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
-   [Dagger2](https://dagger.dev/)
-   [RxJava2](https://github.com/ReactiveX/RxJava)
-   [Retrofit2](https://square.github.io/retrofit/)
-   [Glide](https://github.com/bumptech/glide)
-   [Gson](https://github.com/google/gson)


### License
```
Copyright 2020 ozantopuz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
