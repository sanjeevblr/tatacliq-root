curl --location --request PUT 'http://127.0.0.1:8081/product' \
--header 'Content-Type: application/json' \
--header 'Accept: application/json' \
--data-raw '{
    "product_id": 2,
    "sellerId": 3,
    "title": "Some Tile 2",
    "pageTitle": "Some Page Title 2",
    "description": "Some Description 2",
    "manufacturer": "Samsung",
    "price": {
        "range": 4,
        "min": 1,
        "max": 5
    },
    "isLowQuantity": true,
    "isSoldOut": true,
    "isBackorder": true,
    "metafields": [
        {
            "key": "key1",
            "value": "value"
        }
    ],
    "requiresShipping": true,
    "isVisible": true,
    "workflow": {
        "status": "new"
    }
}'