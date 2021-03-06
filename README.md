## Database
![settlement_db](./img/settlement_db.png)

# π API document

## User

### `POST` /com.pair.user
#### parameter
|Name|Type|In|Description|
|---|---|---|---|
|email|String|body| |
|nickName|String|body| |
|password|String|body| |

<details>
<summary>
μλ΅
</summary>

```json
{
  "id" : "Long"
}
```
</details>


### `POST` /com.pair.user/login
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|email|String|body| |
|password|String|body| |

<details>
<summary> μλ΅ </summary>

```json
{
  "id": "Long"
}
```
</details>


## Owner

### `GET` /com.pair.owner?...
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|id|Long|query-param|**Optional**μ°Ύκ³ μνλ μμ£Όμ μμ΄λκ°|
|name|String|query-param|**Optional**μ°Ύκ³ μ νλ μμ£Όμ μ΄λ¦|
|email|String|query-param|**Optional**μ°Ύκ³ μ νλ μμ£Όμ μ΄λ©μΌ|

<details>
<summary>
μλ΅
</summary>

```json
{
  "id": "Long",
  "name": "String",
  "email": "String",
  "phoneNumber": "String"
}
```
</details>

### `POST` /com.pair.owner
#### parameter
|Name|Type|In|Description|
|---|---|---|---|
|name|String|body| |
|email|String|body| |
|phoneNumber|String|body| |

<details>
<summary>
μλ΅
</summary>

```json
{
  "id": "Long"
}

```

</details>

### `POST` /com.pair.owner/{owner_id}/account
#### parameter
|Name|Type|In|Description|
|---|---|---|---|
|ownerId|Long|query-param|**Required**κ³μ’λ₯Ό μΆκ°νκ³ μνλ μμ£Ό μμ΄λ|
|bank|String|body| |
|bankAccount|String|body| |
|accountHolder|String|body| |

<details>
<summary>
μλ΅
</summary>

```json
{
  "id": "Long"
}

```
</details>

### `PUT` /com.pair.owner
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|id|Long|body| |
|name|String|body| |
|email|String|body| |
|phoneNumber|String|body| |

<details>
<summary>
μλ΅
</summary>

```json
{
  "name": "String",
  "email": "String",
  "phoneNumber": "String"
}
```
</details>

### `PUT` /com.pair.owner/{owner_id}/account
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|ownerId|Long|query-param|**Required**κ³μ’λ₯Ό μΆκ°νκ³ μνλ μμ£Ό μμ΄λ|
|id|Long|body| |
|bank|String|body| |
|bankAccount|String|body| |
|accountHolder|String|body| |

<details>
<summary>
μλ΅
</summary>

```json
{
  "ownerName": "String",
  "bank":  "String",
  "bankAccount":  "String",
  "accountHolder":  "String"
}
```
</details>

## OrderTable

### `POST` /com.pair.order
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|ownerId|Long|body| |
|totalPrice|int|body| |
|status|String|body| |
|createdAt|DateTime|body| |
|detail|List<detail>|body| |
<details>

<summary>
detail
</summary>

```json
{
  "paymentMethod": "String",
  "price": "Integer"
}
```
</details>

<details>
<summary>
μλ΅
</summary>

```json
{
  "id": "Long",
  "detailIds": ["Long"]
}
```
</details>

### `GET` /com.pair.order?com.pair.owner-id=""&com.pair.order-id=""&fromDateTime=""&toDateTime=""
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|com.pair.owner-id|Long|query-param| |
|com.pair.order-id|Long|query-param| |
|fromDateTime|DateTime|query-param| |
|toDateTime|DateTime|query-param| |

<details>
<summary>
μλ΅
</summary>

```json
[
  {
    "ownerId": "Long",
    "orderId": "Long",
    "totalPrice": "Long",
    "status": "String",
    "createdAt": "DateTime"
  }
]
```
</details>

### `GET` /com.pair.order/{com.pair.order-id}/detail
#### parameters
|Name|Type|In|Description|
|---|---|---|---|
|orderId|Long|path-variable| |

<details>
<summary>
μλ΅
</summary>

```json
[
  {
    "orderDetailId": "Long",
    "orderId": "Long",
    "paymentMethod": "String",
    "price": "int"
  } 
]
```
</details>