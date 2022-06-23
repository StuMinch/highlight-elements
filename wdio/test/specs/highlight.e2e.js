describe('My Login application', () => {
    it('should login with valid credentials', async () => {
        await browser.url(`https://the-internet.herokuapp.com/login`);

        const element = await $('#username');

        browser.addCommand('highlightElement',function (element){
            browser.execute('arguments[0].style.backgroundColor = "#FDFF47";', element);//provide a yellow background 
            browser.execute('arguments[0].style.outline = "#f00 solid 4px";', element); //provide a red outline
          });  
          
          browser.highlightElement(element);
        
        await $('#username').setValue('Enter your username');
        
    });
});

