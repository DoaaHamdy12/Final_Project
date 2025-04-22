# ITI_FINAL

This repository contains automated test cases for the Automation Exercise website. The test cases cover various scenarios such as user registration, login, adding products to the cart, and placing orders. This project follows the Page Object Model (POM) for better organization and maintainability.

## Project Overview

The Automation Exercise website offers scenarios for practicing automation testing. This project automates key functionalities, ensuring their correct behavior through test cases covering various user interactions.

## Prerequisites

To run these test cases, ensure the following tools and dependencies are installed:

- **Selenium WebDriver** (for browser automation)
- **Java** (depending on the language you are using)
- **Maven/NPM** (for managing dependencies)
- **TestNG** (for running the test cases)
- **Browser**: Chrome (based on current settings)

## Running the Tests

### Running Selenium Tests

To execute all test cases, use the following command:
```bash
npm test / mvn test
```

You can also run individual test cases by specifying the test case file.


## Project Structure

This project follows a structured layout for better modularity and clarity:

```
ITI_FINAL
│
├── main
│   └── java
│       ├── browserActions          # Handles browser-specific actions
│       ├── driverFactory           # Sets up WebDriver configurations
│       ├── elementActions          # Methods for interacting with web elements
│       ├── listeners               # Test listeners for reporting/logging
│       ├── pages                   # Page Object Model (POM) classes for web pages
│       └── utilities               # Utility classes for reusable methods
│
├── resources
│   ├── Reporting.properties        # Reporting configuration settings
│   └── WebConfigurations.properties # WebDriver and browser settings
│
├── test
    └── java
        └── tests                   # Test classes for each test case
            ├── AddProductsToTheCartTest
            ├── AddReviewOnProduct
            ├── AddToCartFromRecommendedItems
            ├── AllProductsAndFirstProductTest
            ├── ContactUsFormTest
            ├── DownloadInvoiceAfterPurchaseOrderTest
            ├── LoginBeforeCheckout
            ├── LoginUserWithCorrectEmailAndPasswordTest
            ├── LoginUserWithIncorrectEmailAndPasswordTest
            ├── RegisterBeforeCheckout
            ├── RegisterNewUser
            ├── RegisterWhileCheckout
            ├── RegisterWithExistEmailTest
            ├── RemoveProductsFromCart
            ├── ScrollUpWithArrowButtonTest
            ├── ScrollUpWithoutArrowButtonTest
            ├── SearchForProductsTest
            ├── SearchProductsAndVerifyCartAfterLogin
            ├── TestCaseTest
            ├── VerifyAddressDetailsInCheckoutPage
            ├── VerifyProductQuantityInCart
            ├── VerifySubscriptionInCartPageTest
            ├── VerifySubscriptionInHomePageTest
            ├── ViewCartBrandProducts
            └── ViewCategoryProducts
```

### Explanation:

- **browserActions**: Handles browser-level actions like opening and closing.
  
- **driverFactory**: Configures and initializes the WebDriver.

- **elementActions**: Contains methods to interact with web elements like click, type, select, etc.

- **listeners**: Tracks test execution, logs information, and handles reporting.

- **pages**: POM classes representing different pages of the Automation Exercise website.

- **utilities**: Contains utility methods used across different classes.

- **resources**: Includes property files for configuration settings related to WebDriver and reporting.

- **tests**: Contains test classes, each representing a specific scenario (e.g., login, adding products to the cart).

## Test Cases

Here is the list of automated test cases included in this repository:

1. **Register User**: Automates user registration.
2. **Login User with correct email and password**: Verifies login with valid credentials.
3. **Login User with incorrect email and password**: Tests login with invalid credentials.
4. **Logout User**: Verifies user logout functionality.
5. **Register User with existing email**: Tests registration with an existing email.
6. **Contact Us Form**: Verifies the contact form functionality.
7. **Verify Test Cases Page**: Ensures the Test Cases page is displayed correctly.
8. **Verify All Products and product detail page**: Checks product details and listing.
9. **Search Product**: Automates product search functionality.
10. **Verify Subscription in home page**: Tests subscription feature on the homepage.
11. **Verify Subscription in Cart page**: Verifies subscription on the cart page.
12. **Add Products in Cart**: Tests adding products to the cart.
13. **Verify Product quantity in Cart**: Ensures correct product quantity in the cart.
14. **Place Order: Register while Checkout**: Verifies registration during checkout.
15. **Place Order: Register before Checkout**: Tests checkout after registration.
16. **Place Order: Login before Checkout**: Ensures login before placing an order.
17. **Remove Products From Cart**: Tests removing products from the cart.
18. **View Category Products**: Verifies products by category.
19. **View & Cart Brand Products**: Automates viewing and adding brand products to the cart.
20. **Search Products and Verify Cart After Login**: Ensures product search and cart verification post-login.
21. **Add review on product**: Automates adding reviews to products.
22. **Add to cart from Recommended items**: Tests adding products from recommended items to the cart.
23. **Verify address details in checkout page**: Verifies address details on the checkout page.
24. **Download Invoice after purchase order**: Automates downloading invoices after an order.
25. **Verify Scroll Up using 'Arrow' button and Scroll Down functionality**: Verifies scrolling functionality using the arrow button.
26. **Verify Scroll Up without 'Arrow' button and Scroll Down functionality**: Ensures scrolling without using the arrow button.

## Contribution

Contributions are welcome! Feel free to fork this repository, improve the test cases, and submit a pull request.
