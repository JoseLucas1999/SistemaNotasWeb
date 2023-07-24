const bar = document.querySelector('#icon-bar')
const menu = document.querySelector('.mobile-menu')

bar.addEventListener('click', ()=>{
    if(!menu.classList.contains('active')){
        menu.classList.add('active')
        bar.classList.remove('fa-bars')
        bar.classList.add('fa-x')
    }else{
        menu.classList.remove('active')
        bar.classList.remove('fa-x')
        bar.classList.add('fa-bars')   
    }
    
})