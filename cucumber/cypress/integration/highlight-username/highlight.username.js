import { Given, Then } from "cypress-cucumber-preprocessor/steps";

Given('Open the login page', () => {
    cy.visit(`https://the-internet.herokuapp.com/login`);
});  
   
Then(`Highlight the username field`, () => {
    cy.get('#username')
      .then($username => {
        $username.css('border', '4px solid orange')
    })
    cy.screenshot('Enter your username here')
        
});

