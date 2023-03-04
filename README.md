<!-- /TITLE -->
# DynamicPDFGenerator
<!-- /TITLE -->

  This REST API takes input from the user and displays it in the form of a PDF.
# Working

  Below is the working screenchot of the API.
  The user cana add details in the format given below:
  
  ```javascript
  {
	  "seller": "XYZ Pvt. Ltd.",
	  "sellerGstin": "29AABBCCDD121ZD",
	  "sellerAddress": "New Delhi, India",
	  "buyer": "Vedant Computers",
	  "buyerGstin": "29AABBCCDD131ZD",
	  "buyerAddress": "New Delhi, India",
	  "itemsList": [
	   {
	   	"itemName": "Product 1",
	   	"quantity": "12 Nos",
	   	"rate": 123.00,
	   	"amount": 1476.00
	   },
       {
	   	"itemName": "Product 2",
	   	"quantity": "15 Nos",
	   	"rate": 560.00,
	   	"amount": 8400.00
	   }
	  ]
  }
  ```
  
  The API will take the above input and convert in into a PDF as shown below

    ![image](https://user-images.githubusercontent.com/83765713/222924197-1f21aef6-1d56-4b18-9d77-4a02c24355be.png)
