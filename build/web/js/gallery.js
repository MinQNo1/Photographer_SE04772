/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var slideIndex = 0;
showDivs(slideIndex);

function plusDivs(n) {
    showDivs(n);
}

function showDivs(n) {
    var i;
    var x = document.getElementsByClassName("mySlides");
    if (n > x.length) {
        slideIndex = 1;
    }
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    x[n].style.display = "block";
}