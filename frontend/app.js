let studentlist =[
    {
        id:"",
        name:"",
        age:"",
        gender:"",
    }
]
function addStudent() {
    let name = document.getElementById("txtName").value;
    let age = document.getElementById("txtAge").value;
    let gender = document.getElementById("txtGender").value;

    console.log(name, age, gender);

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "name": name,
        "age": age,
        "gender": gender
    });

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
    };

    fetch("http://localhost:8080/student/add", requestOptions)
        .then((response) => response.text())
        .then((result) => {
            console.log(result);
            getAllStudents(); 
        })
        .catch((error) => console.error('Error:', error));
}


function getAllStudents() {
    fetch("http://localhost:8080/student/all")
        .then((response) => response.json())
        .then((students) => {
            studentlist = students;
            console.log("All Students:", students);
            let studentList = document.getElementById("students");
            studentList.innerHTML = ''; 

            students.forEach(student => {
                let li = document.createElement("li");
                li.textContent = `ID: ${student.id}, Name: ${student.name}, Age: ${student.age}, Gender: ${student.gender}`;
                studentList.appendChild(li);
            });
        })
        .catch((error) => console.error('Error:', error));

        console.log(studentlist);
        
}


function searchById() {
    let studentId = document.getElementById("txtSearchId").value;

    fetch(`http://localhost:8080/student/search-by-id/${studentId}`)
        .then((response) => response.json())
        .then((student) => {
            console.log("Student by ID:", student);
            let studentInfo = document.getElementById("studentInfo");
            studentInfo.textContent = `ID: ${student.id}, Name: ${student.name}, Age: ${student.age}, Gender: ${student.gender}`;
        })
        .catch((error) => console.error('Error:', error));
}


function updateStudent() {
    let id = document.getElementById("txtUpdateId").value;
    let name = document.getElementById("txtUpdateName").value;
    let age = document.getElementById("txtUpdateAge").value;
    let gender = document.getElementById("txtUpdateGender").value;

    console.log(id, name, age, gender);

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "id": id,
        "name": name,
        "age": age,
        "gender": gender
    });

    const requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
    };

    fetch("http://localhost:8080/student/update", requestOptions)
        .then((response) => response.text())
        .then((result) => {
            console.log(result);
            getAllStudents(); 
        })
        .catch((error) => console.error('Error:', error));
}


function deleteStudent() {
    let studentId = document.getElementById("txtDeleteId").value;

    fetch(`http://localhost:8080/student/delete/${studentId}`, {
        method: "DELETE",
    })
        .then((response) => response.text())
        .then((result) => {
            console.log(result);
            getAllStudents(); 
        })
        .catch((error) => console.error('Error:', error));
}
