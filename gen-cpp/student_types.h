/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef student_TYPES_H
#define student_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/TBase.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/cxxfunctional.h>




class Student;

typedef struct _Student__isset {
  _Student__isset() : sname(false) {}
  bool sname :1;
} _Student__isset;

class Student : public virtual ::apache::thrift::TBase {
 public:

  Student(const Student&);
  Student& operator=(const Student&);
  Student() : sno(0), sname() {
  }

  virtual ~Student() throw();
  int32_t sno;
  std::string sname;

  _Student__isset __isset;

  void __set_sno(const int32_t val);

  void __set_sname(const std::string& val);

  bool operator == (const Student & rhs) const
  {
    if (!(sno == rhs.sno))
      return false;
    if (__isset.sname != rhs.__isset.sname)
      return false;
    else if (__isset.sname && !(sname == rhs.sname))
      return false;
    return true;
  }
  bool operator != (const Student &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Student & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Student &a, Student &b);

inline std::ostream& operator<<(std::ostream& out, const Student& obj)
{
  obj.printTo(out);
  return out;
}



#endif
