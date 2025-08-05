 function toggleDropdown() {
    document.getElementById("dropdownMenu").classList.toggle("hidden");
  }

  //Default Home pg slider
  let currentIndex = 0;
  const slider = document.getElementById("slider");
  const slides = slider.children;

  function showSlide(index){
    const slideWidth = slides[0].clientWidth;
    slider.style.transform = `translateX(-${index * slideWidth}px)`;
  }
  function nextSlide(){
    currentIndex = (currentIndex +1) % slides.length;
    showSlide(currentIndex);
  }
  function prevSlide(){
    currentIndex = (currentIndex -1 +slides.length) % slides.length;
    showSlide(currentIndex);
  }
  
  showSlide(currentIndex);
  setInterval(nextSlide,5000);