struct Page {
	1: list<Stream> content
	2: bool last
	3: i32 totalElements
	4: i32 totalPages
	5: i32 numberOfElements
	7: bool first
	8: i32 size
	9: i32 number
}

struct Stream {
	1: string id
	2: string name
	3: string thumbnail
	4: string streamer
	5: STREAM_TYPE streamType
	6: i64 viewersCount
	7: string description
}

enum STREAM_TYPE {
	FOOTBALL,
	BASKETBALL
}