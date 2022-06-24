describe('My Login application', () => {
    it('should login with valid credentials', async () => {
        await browser.url(`https://the-internet.herokuapp.com/login`);  
        
        const passwordElement = await $('#password');

        browser.addCommand('highlightElement',function (element){
            browser.execute('arguments[0].style.outline = "#FFA500 solid 4px";', element); //provide a red outline
          });  
          
          browser.highlightElement(passwordElement);
        
    });
});

