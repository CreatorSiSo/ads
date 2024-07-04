use std::collections::VecDeque;

fn main() {
    let books = Vec::from_iter((0..=9_999).map(|_| Book::new_random()));
    // test_vec(&books);
    test_vec_deque(&books);
}

fn test_vec(books: &[Book]) {
    let mut queue = Vec::<Book>::new();
    for book in books {
        queue.push(book.clone());
    }
    while !queue.is_empty() {
        queue.remove(0);
    }
}

fn test_vec_deque(books: &[Book]) {
    let mut queue = VecDeque::<Book>::new();
    for book in books {
        queue.push_front(book.clone());
    }
    while !queue.is_empty() {
        queue.pop_front();
    }
}

#[derive(Clone)]
struct Book {
    isbn: String,
    description: String,
    pages: usize,
    authors: Vec<String>,
    content: String,
}

impl Book {
    fn new_random() -> Self {
        use rand::distributions::{Alphanumeric, DistString};

        Self {
            isbn: Alphanumeric.sample_string(&mut rand::thread_rng(), 17),
            description: Alphanumeric.sample_string(&mut rand::thread_rng(), 350),
            pages: 550,
            authors: vec![Alphanumeric.sample_string(&mut rand::thread_rng(), 10)],
            content: Alphanumeric.sample_string(&mut rand::thread_rng(), 4000),
        }
    }
}

// struct Queue<T> {
//     data: Vec<T>,
// }

// impl<T> Queue<T> {
//     fn new() -> Self {
//         Queue { data: Vec::new() }
//     }

//     fn push(&mut self, element: T) {
//         self.data.push(element);
//     }

//     fn pop(&mut self) -> Option<T> {
//         if self.data.is_empty() {
//             None
//         } else {
//             Some(self.data.remove(0))
//         }
//     }

//     fn is_empty(&self) -> bool {
//         self.data.is_empty()
//     }
// }
