
namespace java pers.harry.test

struct Student {
    1:required i32 sno,
    2:optional string sname,
}

service StudentService {
    void put(1:Student student) # put
    Student get(1:i32 sno)      # get
}

