include "types.thrift"

service Search {
	types.Page search(1: string name, 2: i32 page, 3: i32 size)
	
	types.Page filter(1: types.STREAM_TYPE streamType, 2: i32 page, 3: i32 size)
}