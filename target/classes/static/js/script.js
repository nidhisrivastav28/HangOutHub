// const { data } = require("autoprefixer");

function toggleDropdown() {
  document.getElementById("dropdownMenu").classList.toggle("hidden");
}

//Default Home pg slider
const homeSlider = document.getElementById("slider");
let homeIndex = 0;
const homeSlides = homeSlider.children;

function showHomeSlide(index) {
  const slideWidth = homeSlides[0].clientWidth;
  homeSlider.style.transform = `translateX(-${index * slideWidth}px)`;
}

function nextHomeSlide() {
  homeIndex = (homeIndex + 1) % homeSlides.length;
  showHomeSlide(homeIndex);
}

// Start
showHomeSlide(homeIndex);
setInterval(nextHomeSlide, 3000);

// Plan Page image Slider
//   var swiper = new Swiper(".mySwiper", {
//   loop: true,
//   autoplay: {
//     delay: 1500,
//     disableOnInteraction: false,
//   },
//   pagination: {
//     el: ".swiper-pagination",
//     clickable: true,
//   }
// });
// function validateMood(){
//   let checkboxes = document.querySelectorAll('input[name="mood"]');
//   let isChecked = false;

//   checkboxes.forEach(cb => {
//     if (cb.checked){
//       isChecked = true;
//     }
//   });

//   if(!isChecked){
//     alert("Please select at least one mood");
//   }
// }


// Current Location Data fetching
var uLat;
var uLong;

function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition((position) => {
      uLat = position.coords.latitude;
      uLong = position.coords.longitude;

      document.getElementById("output").innerHTML = "Latitude=" + uLat + "Longitude=" + uLong;
    }, (error) => {
      alert("Error fetching location: " + error.message);
    });
  }
  else {
    alert("Geolocation is not supported by this browser");
  }
}


// Display Places
function showPlaces() {
  fetch('/searchByLocation', {
    method: 'Post',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ latitude: uLat, longitude: uLong })
  })
    .then(response => response.json())
    .then(data => {
      let html = '<table><tr><th>Name</th><th>Description</th><th>Budget</th></tr>';
      data.forEach(place => {
        html += `<tr>
                  <td>${place.name}</td>
                  <td>${place.description}</td>
                  <td>${place.budget}</td>
               </tr>`;
      });
      html += '</table>';
      document.getElementById('results').innerHTML = html;
    })
    .catch(err => console.error(err));
}


// Feedback form script
window.onload = function () {
  const feedbackSuccess = /*[[${feedbackSuccess}]]*/ false;

  if (feedbackSuccess) {
    const popup = document.getElementById("thankyouPopup");
    popup.classList.remove("hidden");

    setTimeout(function () {
      window.location.href = "/home-login";
    }, 2000);
  }
}

// Feedback form star Rating
const star = document.querySelectorAll('.star');
let selectedStar = 0;
star.forEach((star, i) => {
  star.addEventListener("click", () => {
    selectedStar = i;
    updateStars();
  });
});

function updateStars() {
  star.forEach((star, i) => {
    if (i <= selectedStar) {
      star.classList.add("text-yellow-400");
      star.classList.remove("text-gray-300");
    } else {
      star.classList.add("text-gray-300");
      star.classList.remove("text-yellow-400");
    }
  });
}

// Slider for feedback 
const feedbackSlider = document.getElementById("feedbackSlider");
const feedbackSlides = feedbackSlider.children;
let feedbackIndex = 0;

function getSlidesPerView() {
  if (window.innerWidth >= 1024) return 4; // large screen
  if (window.innerWidth >= 768) return 3; // tablet
  if (window.innerWidth >= 640) return 2; // mobile landscape
  return 1; // small mobile
}

function showFeedbackSlide(index) {
  if (feedbackSlides.length === 0) return; // safety check
  const slideWidth = feedbackSlides[0].clientWidth;
  feedbackSlider.style.transform = `translateX(-${index * slideWidth}px)`;
}

function nextFeedbackSlide() {
  const slidesPerView = getSlidesPerView();
  const totalSlides = feedbackSlides.length;

  // Agar totalSlides slidesPerView se kam hai to slide karne ki zarurat nahi
  if (totalSlides <= slidesPerView) return;

  feedbackIndex = (feedbackIndex + 1) % (totalSlides - slidesPerView + 1);
  showFeedbackSlide(feedbackIndex);
}

// Start
showFeedbackSlide(feedbackIndex);
setInterval(nextFeedbackSlide, 3000);

// Resize par reset
window.addEventListener("resize", () => {
  showFeedbackSlide(feedbackIndex);
});