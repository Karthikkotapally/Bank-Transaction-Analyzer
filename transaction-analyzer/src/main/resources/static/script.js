const API="http://localhost:8082/transactions"


function showSection(id){

document.querySelectorAll(".section")
.forEach(s=>s.classList.add("hidden"))

document.getElementById(id).classList.remove("hidden")

if(id==="transactions") loadTransactions()

}



async function addTransaction(){

const data={

description:desc.value,
amount:parseFloat(amount.value),
type:type.value,
date:date.value

}

try {
    const response = await fetch(API,{

    method:"POST",

    headers:{
    "Content-Type":"application/json"
    },

    body:JSON.stringify(data)

    })

    if (response.ok) {
        alert("Transaction Added")
        loadOverallSummary()
    } else {
        alert("Failed to add transaction: " + response.statusText)
    }
} catch (error) {
    alert("Error adding transaction: " + error.message)
}

}



async function loadTransactions(){

try {
    const response = await fetch(API)
    if (!response.ok) {
        alert("Failed to load transactions: " + response.statusText)
        return
    }
    const all = await response.json()
    const table=document.getElementById("transactionTable")

    table.innerHTML=""

    all.forEach(t=>{

    table.innerHTML+=`

    <tr>

    <td>${t.description}</td>

    <td>${t.amount}</td>

    <td>
    <span class="${t.type==='DEBIT'?'debit':'credit'}">
    ${t.type}
    </span>
    </td>

    <td>${t.date}</td>

    </tr>

    `

    })
} catch (error) {
    alert("Error loading transactions: " + error.message)
}

}



async function getSummary(){

const year=document.getElementById("year").value
const month=document.getElementById("month").value

try {
    const response = await fetch(API+`/summary?year=${year}&month=${month}`)
    if (!response.ok) {
        alert("Failed to load summary: " + response.statusText)
        return
    }
    const data=await response.json()

    summaryDebit.innerText=data.totalDebit
    summaryCredit.innerText=data.totalCredit

    totalDebit.innerText=data.totalDebit
    totalCredit.innerText=data.totalCredit

    balance.innerText=data.totalCredit-data.totalDebit
} catch (error) {
    alert("Error loading summary: " + error.message)
}

}

async function loadOverallSummary(){

try {
    const response = await fetch(API+`/overall-summary`)
    if (!response.ok) {
        alert("Failed to load overall summary: " + response.statusText)
        return
    }
    const data=await response.json()

    totalDebit.innerText=data.totalDebit
    totalCredit.innerText=data.totalCredit

    balance.innerText=data.totalCredit-data.totalDebit
} catch (error) {
    alert("Error loading overall summary: " + error.message)
}

}

window.onload = loadOverallSummary