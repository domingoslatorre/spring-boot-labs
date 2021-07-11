const oneMoreItemBtn = document.querySelector("#oneMore");

if(getNextFormGroupId() == 0) {
  addShopListItemForm();
}

oneMoreItemBtn.addEventListener("click", function(event) {
  event.preventDefault();
  addShopListItemForm();
});

function getNextFormGroupId() {
  return document.querySelectorAll("#listItem .form-group").length
}

function addShopListItemForm() {
  document.querySelector("#listItem").appendChild(getShopListItemForm(getNextFormGroupId()))
}

function getShopListItemForm(nextFormGroupId) {
  const div = document.createElement("div");
  div.classList.add("form-group");
  div.setAttribute("data-item-id", nextFormGroupId);

  const inputName = document.createElement("input");
  inputName.setAttribute("type", "text");
  inputName.setAttribute("id", "itens" + nextFormGroupId + ".name");
  inputName.setAttribute("name", "itens[" + nextFormGroupId + "].name");

  const inputQuantity = document.createElement("input")
  inputQuantity.setAttribute("type", "text");
  inputQuantity.setAttribute("id", "itens" + nextFormGroupId + ".quantity");
  inputQuantity.setAttribute("name", "itens[" + nextFormGroupId + "].quantity");

  const hr = document.createElement("hr")
  div.appendChild(inputName);
  div.appendChild(inputQuantity);
  div.appendChild(hr);

  return div;
}