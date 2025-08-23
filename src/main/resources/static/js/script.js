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

// Plan Page image Slider
  var swiper = new Swiper(".mySwiper", {
  loop: true,
  autoplay: {
    delay: 1500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  }
});

// Current Location Data fetching
var uLat;
var uLong;

function getLocation(){
  if(navigator.geolocation){
    navigator.geolocation.getCurrentPosition((position) =>{
      uLat = position.coords.latitude;
      uLong = position.coords.longitude;

      document.getElementById("output").innerHTML = "Latitude=" +uLat+ "Longitude="+uLong; 
    }, (error) => {
      alert("Error fetching location: "+error.message);
    });
  }
  else{
    alert("Geolocation is not supported by this browser");
  }
}