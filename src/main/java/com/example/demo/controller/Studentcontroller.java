@Restcontroller
public class StudentController {
@Autowired
StudentService studentService;
@PostMapping("/PostStudent")
public Student postStd(@RequestBody Student st){
return studentService.insertStudent(st);
}
@GetMapping("/getAll")
public List<Student> getAll()
return studentService.getAllStudents();
}
@GetMapping("/get/{id}")
public Optional<Student> get(@PathVariable Long id){
return studentService.getOneStudent(id);
}
@PutMapping("/update/{id}")
public String update(@PathVariable Long id,@RequestBody Student
newStudent){
Optional<Student> student=studentService.getOneStudent(id);
if(student.isPresent()){
newStudent.setId(id);
studentService.insertStudent(newStudent);
return "Updated Success";
}
return "Id not found";
}
@DeleteMapping("/del/{id}")
public String deleteStudent(@PathVariable Long id){
Optional<Student> student=studentService.getOneStudent(id);
if(student.isPresent()){
studentService.deleteStudent(id);
return "Deleted Success";
}
return "Id Not Found";
}
}