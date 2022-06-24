import { Given, Then } from "cypress-cucumber-preprocessor/steps";

Given('Open the login page', () => {
    cy.visit(`https://the-internet.herokuapp.com/login`);
});  
   
Then(`Highlight the password field`, () => {
    cy.get('#password')
      .then($password => {
        $password.css('border', '4px solid orange')
    })
    cy.screenshot('Enter your password here')
        
});

