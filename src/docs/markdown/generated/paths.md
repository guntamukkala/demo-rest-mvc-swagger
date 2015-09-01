## Paths
### List IL JUG Members
```
GET /iljugmembers/
```

#### Description

Returns the IL JUG Members list

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|Iterable«IlJugMember»|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* iljugmembers

### Create a new IL JUG Member
```
POST /iljugmembers/
```

#### Description

Returns the newly created IL JUG Member

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|last|Last name of IL JUG Member|true|string||
|QueryParameter|first|First name of IL JUG Member|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|IlJugMember|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* iljugmembers

### Find IL JUG Member by last name
```
GET /iljugmembers/search
```

#### Description

Returns the IL JUG Members with matching last name

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|last|Last name of IL JUG Member|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|Iterable«IlJugMember»|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* iljugmembers

### Find IL JUG Member by ID
```
GET /iljugmembers/{id}
```

#### Description

Returns the IL JUG Member found

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|ID of the IL JUG Member|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|IlJugMember|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json

#### Tags

* iljugmembers

### Update an IL JUG Member details
```
PUT /iljugmembers/{id}
```

#### Description

Updates an IL JUG Member first/last name details

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|ID of the IL JUG Member|true|integer (int64)||
|QueryParameter|last|Last name of IL JUG Member|true|string||
|QueryParameter|first|First name of IL JUG Member|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|null|No Content|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* iljugmembers

### Delete IL JUG Member
```
DELETE /iljugmembers/{id}
```

#### Description

Deletes the IL JUG Member from the system

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|ID of the IL JUG Member|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|401|Unauthorized|No Content|
|204|No Content|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* iljugmembers

