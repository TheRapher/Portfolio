window.onscroll = function() {logoScroll()};

function logoScroll() {
  if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
    document.getElementById("logo").classList.add("logoSmall");
  } else {
    document.getElementById("logo").classList.remove("logoSmall");
  }
} 