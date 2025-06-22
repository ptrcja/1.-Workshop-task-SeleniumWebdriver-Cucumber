# Address Management Test Automation Project

## What This Project Does

This project automatically tests how customers manage their delivery addresses on an e-commerce website. Instead of manually checking that address forms work correctly, my automated tests verify the complete address lifecycle - from creation to deletion - ensuring customers can reliably manage their shipping information.

### Business Impact
- **Prevents Failed Deliveries**: Catches address form bugs before they cause shipping problems
- **Reduces Returns**: Ensures accurate address capture prevents packages going to wrong locations
- **Improves Customer Trust**: Customers can confidently manage their delivery preferences
- **Saves Support Time**: Fewer calls about "where's my package?" issues

## What Gets Tested

The automated tests verify the complete address management experience:

1. **Login** → Can customers access their account?
2. **Navigate to Addresses** → Is the address section accessible?
3. **Create New Address** → Does the address form work properly?
4. **Verify Details** → Are all address fields saved correctly?
5. **Delete Address** → Can customers remove old addresses?
6. **Confirm Deletion** → Is the deletion properly confirmed?

## Real Test Example

The tests are written in plain English using Behavior Driven Development (BDD):

```gherkin
Given I'm logged into my account
When I create a new address with "Home", "Avenida Marconi", "Lisbon"
Then all my address details should be saved correctly
And I should be able to delete the address when no longer needed
```

## How It Works

Think of it like a meticulous customer who:
- Signs into their account
- Navigates to address management
- Carefully fills out address forms
- Double-checks every detail is correct
- Tests the delete functionality
- Reports any problems immediately

## Results

| What We Test | Status | Business Value |
|--------------|--------|----------------|
| Address Form Validation | Working | Prevents shipping errors |
| Data Persistence | Working | Ensures reliable storage |
| Address Deletion | Working | Allows account cleanup |
| Success Messaging | Working | Clear user feedback |

## Technologies Used

- **Selenium WebDriver**: Controls the web browser automatically
- **Java**: Programming language for test logic
- **Cucumber BDD**: Makes tests readable in plain English
- **Page Object Model**: Keeps test code organized and maintainable
- **JUnit**: Executes tests and validates results

## Test Architecture

The project follows industry best practices:

```
Pages/ → Each webpage has its own class
├── AuthenticationPage → Handles login
├── MyAccountPage → Account navigation  
├── AddressesPage → Address list management
└── NewAddressPage → Address form operations

Steps/ → Test scenarios in plain English
Features/ → Business requirements as test cases
```

## Running the Tests

```bash
# Execute address management tests
mvn test

# View test report
Open: target/cucumber-report.html
```

## Proof of Success

Automation validates address data integrity and provides clear success confirmations.


https://github.com/user-attachments/assets/81a23d9f-90b4-47b4-86f2-6ad280525bf2


## My Learnings

Address bugs are expensive: What looks like a simple form actually causes a ton of headaches - wrong addresses mean failed deliveries, angry customers calling support, and packages bouncing back

Learned to test in depth: Instead of just checking if forms submit, I validated the complete data journey - ensuring what customers type matches exactly what gets saved and displayed back
