# EShop - Advanced Programming Module
###### Deanita Sekar Kinasih
###### 2306229405

#### Tautan deployment: https://jittery-spoonbill-deanitasekar-109abb36.koyeb.app/

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

<details>
<summary><b>Module 2 - CI/CD & DevOps</b></summary>
  
**You have implemented a CI/CD process that automatically runs the test suites, analyzes code quality, and deploys to a PaaS. Try to answer the following questions in order to reflect on your attempt completing the tutorial and exercise.**

**1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.**

- Menghapus unnecessary modifier public

Pada interface `ProductService`, semua method dideklarasikan dengan modifier public. Seharusnya, semua method dalam interface secara default bersifat public. Oleh karena itu, saya menghapus modifier tersebut agar tidak bersifat redundant.
```java
public interface ProductService {
    Product create(Product product);
    List<Product> findAll();
    Product getProductById(String productId);
    void edit(String productId, Product selectedProduct);
    void delete(String productId);
}
```

- Menghapus unnecessary semicolon
  
Pada ProductRepository, saya melakukan kesalahan dengan menuliskan dua semicolon dalam satu line. Untuk menjaga prinsip clean code, saya menghapus salah satu semicolon pada line tersebut.
```java
private List<Product> productData = new ArrayList<>();
```

- Mengganti unused import dengan spesific import
  
Pada HomeController dan ProductController, saya menggunakan `import org.springframework.web.bind.annotation.*` yang berpotensi menggunakan lebih banyak memori. Untuk menghindari itu, saya mengganti import tersebut dengan import yang lebih spesifik.
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
```
```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
```

**2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!**

Menurut saya, implementasi yang saya lakukan sudah memenuhi definisi Continuous Integration dan Continuous Deployment secara komprehensif. Dari segi CI, saya telah melakukan integrasi dengan berbagai workflow yaitu `ci.yml`, `scorecard.yml`, dan `pmd.yml`. Setiap kali terjadi perubahan kode, GitHub Actions secara otomatis menjalankan test untuk melakukan verifikasi fungsionalitas dan code quality. Dalam aspek CD, deployment menggunakan Koyeb memungkinakn setiap perubahan kode untuk diterapkan secara langsung tanpa intervensi manual. Apabila terjadi kesalahan, sistem akan memberikan umpan balik secara cepat sehingga kode dapat diperbaiki sebelum deployment. Dengan demikian, seluruh proses dari integrasi hingga deployment berjalan secara otomatis dan terstandardisasi, meningkatkan efisiensi pengembangan, meminimalkan bug, serta mengoptimalkan kode.

</details>

<details>
<summary><b>Module 3 - Maintainability & OO Principles-v2</b></summary>
  
**1. Explain what principles you apply to your project!**

- Single Responsibility Principle (SRP)

  Setiap class berfokus pada satu tugas saja. Contohnya adalah memisahkan `CarController` dari `ProductController` karena terdapat perbedaan tugas. 

- Open-Closed Principle (OCP)

  Sebuah class harus bersifat open terhadap extension, tetapi closed terhadap modification. Contohnya adalah tidak secara langsung melakukan modifikasi terhadap objek Car pada method `update` di `CarRepository`

- Liskov Substitution Principle (LSP)

  Suatu subclass dapat menggantikan superclass tanpa memengaruhi efektivitas keselutuhan kode. Contohnya adalah `CarController` tidak seharusnya menjadi sublass `ProductController` karena `CarController` tidak bisa menggantikan `ProductController` akibat perbedaan fungsi dan sifat

- Interface Segregation Principle (ISP)

  Setiap class mengimplementasikan interface yang relevan dengan fungsi class tersebut. Contohnya adalah `ProductServiceImpl` mengimplementasikan `ProductService` serta `CarServiceImpl` mengimplementasikan `CarService`

- Dependency Inversions Principle (DIP)

  Class seharusnya bergantung pada Interface/Abstract Class, bukan pada Concrete Class. Contohnya dalam `CarController`, `carService` seharusnya mengimplementasikan Interface `CarService`, bukan `CarServiceImpl`

**2. Explain the advantages of applying SOLID principles to your project with examples.**

Dengan mengimplementasikan SOLID principle, kita dapat meningkatkan readability, maintainability, efficiency, dan flexibility project. Penerapan SOLID principle menghasilkan kode yang terstruktur dan modular sehingga developer dapat melakukan modifikasi dengan mudah di masa mendatang. 
Contoh:
- `CarController` tidak menangani logika bisnis, melainkan hanya menangani permintaan HTTP dan merender tampilan. Sedangkan, `CarServiceImpl` digunakan untuk menangani logika bisnis
- `CarService` dapat dimodifikasi dengan penambahan fitur tanpa mengubah `CarServiceImpl` atau `CarController`
- Penggunaan `CarService` Interface di `CarController` memudahkan pergantian `CarServiceImpl` dengan implementasi lain

**3. Explain the disadvantages of not applying SOLID principles to your project with examples.**

Tanpa penerapan SOLID principles, kode menjadi tidak fleksibel, fragile, dan stagnant. Rendahnya readability dapat memunculkan tantangan maintainability yang signifikan. Proses pengembangan akan menjadi lebih kompleks karena modifikasi pada satu bagian dapat menimbulkan efek pada bagian lain. Selain itu, proses testing juga menjadi lebih sulit sehingga memperlambat siklus pengembangan.
Contoh
- Tanpa penerapan SRP, `CarController` dan `CarService` harus diubah setiap dilakukan perubahan penyimpanan data
- Tanpa penerapan ISP, `CarController` yang hanya membutuhkan `create` dan `findAll` terpaksa mengimplementasikan metode yang tidak diperlukan karena `CarService` memiliki metode create, update, delete, dan findAll. 
- Tanpa penerapan DIP, akan terjadi kesulitan penggantian implementasi karena `CarController` langsung bergantung pada `CarServiceImpl` dan bukan `CarService` Interface

</details>
