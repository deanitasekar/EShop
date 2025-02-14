# EShop - Advanced Programming Module
###### Deanita Sekar Kinasih
###### 2306229405

<details>
<summary><b>Module 1 - Coding Standards</b></summary>

### Reflection 1

**You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code. Please write your reflection inside the repository's README.md file.**

Pada module kali ini, saya sudah menerapkan clean code principles dengan aturan penamaan mudah dipahami, seperti `ProductController` dan `ProductService`, yang menggambarkan fungsionalitas komponen. Saya juga menerapkan small functions, dimana setiap method seperti `createProduct` memiliki fungsionalitas yang spesifik. Dalam separation of concerns, saya memisahkan kode ke dalam beberapa lapisan untuk membuat arsitektur aplikasi tersusun rapi, yaitu `controllers`, `services`, `repositories`, dan `models`. Saya juga telah menerapkan penulisan kode yang konsisten dengan indentasi tepat dan mengikuti konvensi penamaan Java sehingga kode dapat dibaca dengan baik.

Selain itu, saya juga menerapkan secure coding practices dengan validasi eksplisit menggunakan anotasi seperti `@NotNull` dan `@Size` untuk memastikan kriteria data. Prnggunaan ArrayList cenderung aman untuk menghindari SQL Injection dan pertimbangan penggunaan parameterized queries atau ORM.

Pada awalnya, saya sempat melakukan kesalahan dengan penulisan kode yang kurang to-the point dan menambahkan beberapa comment. Setelah mempelajari lebih lanjut mengenai clean coding principles (comments do not make up for bad code), saya memutuskan untuk menulis ulang kode tersebut agar tidak memberikan comment. Berdasarkan kesalahan yang saya lakukan, saya mendapatkan lebih banyak ilmu mengenai clean codes principles dan secure coding practices.

### Reflection 2
**1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?**

Membuat unit test merupakan pengalaman yang menantang sekaligus memberikan kepuasan tersendiri bagi saya. Pada awalnya, terasa membingungkan untuk menulis test keseluruhan kode, terutama pada bagian kode yang cukup kompleks. Namun, setelah selesai membuat unit test, saya merasa kode saya cukup aman karena memastikan kode untuk berjalan sesuai dengan fungsionalitasnya. 

Jumlah unit test yang diperlukan dalam satu class bergantung dengan kompleksitas class yang diuji. Tidak ada jumlah yang pasti, tetapi terdapat beberapa cakupan pengujian, yaitu, setiap method dalam class, boundary conditions dan kasus-kasus khusus, penanganan error, serta percabangan dan kondisional. Fokus dari unit test harus mencapai cakupan yang tinggi sambil memastikan test yang menyeluruh.

Terdapat berbagai cara untuk memastikan unit test cukup untuk memverifikasi program, yaitu melakukan boundary testing, menguji hasil terhadap error, serta menggunakan test-driven development jika memungkinkan

100% code coverage bukan berarti tidak ada bug, melainkan berarti semua baris kode telah dieksekusi oleh test setidaknya sekali. Code coverage hanya memastikan pengujian kdoe, tetapi tidak menyatakan kualitas test tersebut. Dapat disimpulkan bahwa code coverage 100% menyatakan bahwa kode telah diuji dengan baik dari segi eksekusi, tetapi belum tentu menyatakan bahwa kode bebas dari bug. 


**2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!**

Ketika membuat test functional test untuk memastikan jumlah item dalam daftar produk setelah membuat CreateProductFunctionalTest, masalah utama yang muncul adalah redundasi. Meskipun fungsi test tidak memiliki pengaruh yang signifikan, prosedur setup dan variable instance yang sama berpotensi melanggar clean code principles. Terdapat beberapa potensi clean code issues, yaitu:

- Duplication of test setup

  Setup kedua test case hampir identik menyebabkan duplikasi kode dan meningkatkan kompleksitas maintenance. 
- Pelanggaran prinsip DRY (Don't Repeat Yourself)

  Pengulangan setup, variabel instance, atau test case dapat meningkatkan risiko kesalahan saat melakukan perubahan
- Test fragility

  Kode setup yang terduplikasi menyebabkan perubahan pada infrastruktur test harus direplikasi di setiap class sehingga dapat menimbulkan kesalahan

Untuk menjaga clean codes, sebaiknya menghindari duplikasi dengan ekstrasi logika, menggunakan parameterized test, dan mengelompokkan test. Dengan menerapkan ini, kode akan lebih mudah dibaca, lebih efisien, dan lebih mudah dilakukan maintenance. 
</details>