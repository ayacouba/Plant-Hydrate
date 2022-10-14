 //Get access to elements
        const text = document.getElementById("text");
        const addPlantButton = document.getElementById("add-plant-btn");
        const savePlantButton = document.getElementById("save-plant-btn");
        const listBox = document.getElementById("plants");
        const saveInd = document.getElementById("saveIndex");

        //Store plants
        let plantArray = [];

        //Add plant and push to plantArray and use click on add button
        addPlantButton.addEventListener("click", (e) => {
            e.preventDefault();
            let plant = localStorage.getItem("plant");
            if (plant === null) {
                plantArray = [];
            } else {
                plantArray = JSON.parse(plant);
            }
            plantArray.push(text.value);
            text.value = "";
            localStorage.setItem("plant", JSON.stringify(plantArray));
            displayPlant();
        });

//Display plants
        function displayPlant() {
            let plant = localStorage.getItem("plant");
            if (plant === null) {
                plantArray = [];
            } else {
                plantArray = JSON.parse(plant);
            }
            let htmlCode = "";
            plantArray.forEach((list, ind) => {
                htmlCode += `<div class='flex mb-4 items-center'>
   <p class='w-full text-grey-darkest'>${list}</p>
   <button onclick='edit(${ind})' class='flex-no-shrink p-2 ml-4 mr-2 border-2 rounded text-white '>Edit</button>
   <button onclick='deletePlant(${ind})' class='flex-no-shrink p-2 ml-2 border-2 rounded '>Delete</button>
</div>`;
            });
            listBox.innerHTML = htmlCode;
        }

//Delete Plant
        function deletePlant(ind) {
            let plant = localStorage.getItem("plant");
            plantArray = JSON.parse(plant);
            //splice() method deletes the item at the specified index
            plantArray.splice(ind, 1);
            //store changes to local storage
            localStorage.setItem("plant", JSON.stringify(plantArray));
            displayPlant();
        }

//Edit plant and save to local storage
        function edit(ind) {
            saveInd.value = ind;
            let plant = localStorage.getItem("plant");
            plantArray = JSON.parse(plant);
            text.value = plantArray[ind];
            addPlantButton.style.display = "none";
            savePlantButton.style.display = "block";
        }

        savePlantButton.addEventListener("click", () => {
            let plant = localStorage.getItem("plant");
            plantArray = JSON.parse(plant);
            let id = saveInd.value;
            plantArray[id] = text.value;
            addPlantButton.style.display = "block";
            savePlantButton.style.display = "none";
            text.value = "";
            localStorage.setItem("plant", JSON.stringify(plantArray));
            displayPlant();
        });
