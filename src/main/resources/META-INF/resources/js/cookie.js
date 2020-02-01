window.addEventListener("load", function() {
    window.cookieconsent.initialise({
        onInitialise: function(status) {
            if (this.hasConsented('required')) {
            }
        },
        onAllow: function(category) {
            if (category == 'required') {
            }
        },
        onRevoke: function(category) {
            if (category == 'required') {
            }
        }
    })
});
