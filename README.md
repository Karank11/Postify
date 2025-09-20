# Postify

Postify is an Android application that demonstrates a modern approach to Android development. It showcases a list of posts, each with an image, title, and description, in a scrollable view. The app also includes functionality to browse posts by category.

## Features

* Displays a list of posts fetched from a data source.
* Each post item shows an image, title, and description.
* **Allows users to browse posts based on different categories.**
* Utilizes a ViewModel to manage UI-related data in a lifecycle-conscious way.
* Asynchronously loads images from URLs.

## Technologies Used

This project leverages a combination of modern Android development technologies:

* **Kotlin:** The primary programming language for Android development, known for its conciseness and safety features.
* **Jetpack Compose:** Android's modern toolkit for building native UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.
* **Hilt**: A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
* **Coil**: An image loading library for Android backed by Kotlin Coroutines. Used here for asynchronously loading and displaying images from URLs with features like crossfade animations.
* **Navigation Compose**: Part of Jetpack Navigation, allowing for declarative navigation between composables. This is likely used for navigating between the Category screen and the Detail screen.

## Code Structure

### `CategoryScreen.kt`

* **Main Purpose**
    * This screen serves as the primary navigation point for browsing content. It displays a list of all available post categories, such as "Technology," "Lifestyle," or "Science."
    * It allows users to select a category to view a filtered list of posts relevant only to that topic on the `DetailScreen`.
* **Key Composables and their roles**
    * `CategoryScreen`: The main composable that orchestrates the screen's UI. It would likely contain a title and the `CategoryList`.
    * `CategoryList`: A composable that uses a `LazyVerticalGrid` or `LazyColumn` to efficiently display the categories fetched from the `CategoryViewModel`.
    * `CategoryItem`: A reusable composable representing a single category. It's likely implemented as a `Card` containing the category name (e.g., using a `Text` composable) and perhaps a representative icon or image. It handles the click event for navigation.
* **Data Flow**
    * The `CategoryScreen` obtains an instance of a `CategoryViewModel` (which would need to be created) using `hiltViewModel()`.
    * The ViewModel is responsible for fetching the list of available categories from a repository (e.g., from a network API or a local database).
    * The UI observes a `StateFlow` or `LiveData` from the ViewModel to get the list of categories and displays them.
* **Interaction**
    * When a user taps on a `CategoryItem`, an `onClick` lambda is triggered.
    * This action uses the `NavController` to navigate to the `DetailScreen`.
    * Crucially, it passes the unique identifier of the selected category (e.g., `categoryId`) as a navigation argument to the `DetailScreen`. The `DetailScreen`'s `PostViewModel` would then use this argument to fetch and display only the posts belonging to that category.

### `DetailScreen.kt`

* This file contains the main Composable function responsible for displaying the list of posts (potentially filtered by a category).
    * **`DetailScreen` Composable**:
        * Obtains an instance of `PostViewModel` using `hiltViewModel()`.
        * Collects the list of posts (`items`) from the ViewModel as a State using `viewModel.items.collectAsState()`.
        * Uses a `LazyColumn` to efficiently display the list of posts.
        * For each post in the `posts` list, it calls the `Item` composable.
    * **`Item` Composable**:
        * Represents a single item in the list.
        * Uses a `Card` to give a Material Design look and feel with elevation.
        * Arranges an `AsyncImage` (for the post image) and a `Column` (for title and description) within a `Row`.
        * `AsyncImage` (from Coil) loads the image from `item.imageUrl`.
        * `Text` composables display the `item.title` and `item.description`.
    * **`PreviewScreen` Composable**:
        * A `@Preview` annotated function for previewing the `DetailScreen`.

## Future Enhancements (Suggestions)

* Implement actual data fetching from a remote API or local database in `PostViewModel` and a potential `CategoryViewModel`.
* Add error handling for network requests.
* Implement click listeners on items to navigate to a more detailed view of a post.
* Add unit and UI tests.
* Enhance UI/UX with more animations, theming, and responsive layouts.
* **Refine category filtering logic and UI.**
